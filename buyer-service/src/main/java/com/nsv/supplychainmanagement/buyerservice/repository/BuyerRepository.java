package com.nsv.supplychainmanagement.buyerservice.repository;

import com.nsv.supplychainmanagement.buyerservice.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
}