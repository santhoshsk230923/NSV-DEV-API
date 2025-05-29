package com.nsv.supplychainmanagement.dashboardservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class Auth0TokenService {

    private final WebClient webClient;

    @Value("${auth0.token-uri}")
    private String tokenUri;

    @Value("${auth0.client-id}")
    private String clientId;

    @Value("${auth0.client-secret}")
    private String clientSecret;

    @Value("${auth0.audience}")
    private String audience;

    private final AtomicReference<String> cachedToken = new AtomicReference<>();
    private final AtomicReference<Instant> expiryTime = new AtomicReference<>(Instant.EPOCH);

    public Auth0TokenService(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    public Mono<String> getAccessToken() {
        Instant now = Instant.now();

        if (cachedToken.get() != null && expiryTime.get().isAfter(now.plusSeconds(30))) {
            return Mono.just(cachedToken.get());
        }

        return fetchNewToken();
    }

    private Mono<String> fetchNewToken() {
        return webClient.post()
                .uri(tokenUri)
                .bodyValue(Map.of(
                        "client_id", clientId,
                        "client_secret", clientSecret,
                        "audience", audience,
                        "grant_type", "client_credentials"
                ))
                .retrieve()
                .bodyToMono(Map.class)
                .retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(2)))
                .map(response -> {
                    String token = (String) response.get("access_token");
                    log.info("Fetched new Auth0 token {}", token);
                    Integer expiresIn = (Integer) response.get("expires_in");

                    if (token != null && expiresIn != null) {
                        cachedToken.set(token);
                        expiryTime.set(Instant.now().plusSeconds(expiresIn));
                        log.info("Fetched new Auth0 token valid for {} seconds", expiresIn);
                    }
                    return token;
                });
    }
}
