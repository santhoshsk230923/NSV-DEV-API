package com.nsv.supplychainmanagement.buyerservice.service;

import com.nsv.supplychainmanagement.buyerservice.model.Buyer;

import java.util.List;

public interface BuyerService {
    Buyer createBuyer(Buyer buyer);
    Buyer getBuyerById(Integer id);
    List<Buyer> getAllBuyers();
    Buyer updateBuyer(Integer id, Buyer buyer);
    void deleteBuyer(Integer id);
}
