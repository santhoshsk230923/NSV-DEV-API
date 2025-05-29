package com.nsv.supplychainmanagement.dashboardservice.service;

import com.nsv.supplychainmanagement.dashboardservice.model.DashboardMetrics;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class DashboardServiceImpl implements DashboardService {

    private final WebClient webClient;
    private final Auth0TokenService tokenService;

    @Value("${supply.url}")
    private String supplyUrl;

    @Value("${processing.url}")
    private String processingUrl;

    @Value("${dispatch.url}")
    private String dispatchUrl;

    @Value("${invoice.url}")
    private String invoiceUrl;

    @Value("${transactions.url}")
    private String transactionsUrl;

    public DashboardServiceImpl(WebClient.Builder webClientBuilder, Auth0TokenService tokenService) {
        this.webClient = webClientBuilder.build();
        this.tokenService = tokenService;
    }


    @Override
    public DashboardMetrics getDashboardMetrics() {
        Mono<BigDecimal> supply = getMetricAsync(supplyUrl);
        Mono<BigDecimal> processing = getMetricAsync(processingUrl);
        Mono<BigDecimal> dispatch = getMetricAsync(dispatchUrl);
        Mono<BigDecimal> revenue = getMetricAsync(invoiceUrl);
        Mono<BigDecimal> paid = getMetricAsync(transactionsUrl);

        return Mono.zip(supply, processing, dispatch, revenue, paid)
                .map(tuple -> {
                    BigDecimal totalSupply = tuple.getT1();
                    BigDecimal totalProcessed = tuple.getT2();
                    BigDecimal totalDispatched = tuple.getT3();
                    BigDecimal totalRevenue = tuple.getT4();
                    BigDecimal totalPaid = tuple.getT5();

                    DashboardMetrics metrics = new DashboardMetrics();
                    metrics.setTotalSupplyReceived(totalSupply);
                    metrics.setTotalProcessed(totalProcessed);
                    metrics.setTotalDispatched(totalDispatched);
                    metrics.setTotalRevenue(totalRevenue);
                    metrics.setTotalAmountPaid(totalPaid);
                    metrics.setProcessingEfficiency(calculatePercentage(totalProcessed, totalSupply));
                    metrics.setDispatchEfficiency(calculatePercentage(totalDispatched, totalProcessed));
                    metrics.setWastePercentage(BigDecimal.ZERO); // Optional logic
                    metrics.setAveragePricePerMT(calculateAverage(totalRevenue, totalDispatched));
                    return metrics;
                }).block(); // You can switch to a reactive endpoint to avoid blocking
    }

    private Mono<BigDecimal> getMetricAsync(String url) {
        return tokenService.getAccessToken()
                .flatMap(token -> webClient.get()
                        .uri(url)
                        .headers(h -> h.setBearerAuth(token))
                        .retrieve()
                        .bodyToMono(BigDecimal.class)
                        .onErrorResume(ex -> {
                            // log the error and fallback
                            return Mono.just(BigDecimal.ZERO);
                        }));
    }

    private BigDecimal calculatePercentage(BigDecimal part, BigDecimal whole) {
        if (whole == null || whole.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ZERO;
        return part.divide(whole, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateAverage(BigDecimal total, BigDecimal quantity) {
        if (quantity == null || quantity.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ZERO;
        return total.divide(quantity, 2, RoundingMode.HALF_UP);
    }
}
