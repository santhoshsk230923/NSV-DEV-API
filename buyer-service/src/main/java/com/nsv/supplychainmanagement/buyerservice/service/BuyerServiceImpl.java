package com.nsv.supplychainmanagement.buyerservice.service;

import com.nsv.supplychainmanagement.buyerservice.model.Buyer;
import com.nsv.supplychainmanagement.buyerservice.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public Buyer createBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer getBuyerById(Integer id) {
        return buyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer updateBuyer(Integer id, Buyer buyer) {
        if (!buyerRepository.existsById(id)) {
            return null;
        }
        buyer.setBuyerId(id);
        return buyerRepository.save(buyer);
    }

    @Override
    public void deleteBuyer(Integer id) {
        buyerRepository.deleteById(id);
    }
}
