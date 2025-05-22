package com.nsv.supplychainmanagement.dispatchservice.service;

import com.nsv.supplychainmanagement.dispatchservice.model.Dispatch;

import java.util.List;
import java.util.Optional;

public interface DispatchService {

    Dispatch createDispatch(Dispatch dispatch);
    List<Dispatch> getAllDispatches();
    Optional<Dispatch> getDispatchById(Integer id);
    Dispatch updateDispatch(Integer id, Dispatch dispatch);
    void deleteDispatch(Integer id);
}
