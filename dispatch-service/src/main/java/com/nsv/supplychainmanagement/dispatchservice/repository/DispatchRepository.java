package com.nsv.supplychainmanagement.dispatchservice.repository;

import com.nsv.supplychainmanagement.dispatchservice.model.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatchRepository extends JpaRepository<Dispatch, Integer> {
}
