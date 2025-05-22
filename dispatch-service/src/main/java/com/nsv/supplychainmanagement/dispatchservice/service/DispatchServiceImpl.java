package com.nsv.supplychainmanagement.dispatchservice.service;
import com.nsv.supplychainmanagement.dispatchservice.model.Dispatch;
import com.nsv.supplychainmanagement.dispatchservice.repository.DispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispatchServiceImpl implements DispatchService {

    private final DispatchRepository dispatchRepository;

    @Autowired
    public DispatchServiceImpl(DispatchRepository dispatchRepository) {
        this.dispatchRepository = dispatchRepository;
    }

    @Override
    public Dispatch createDispatch(Dispatch dispatch) {
        return dispatchRepository.save(dispatch);
    }

    @Override
    public List<Dispatch> getAllDispatches() {
        return dispatchRepository.findAll();
    }

    @Override
    public Optional<Dispatch> getDispatchById(Integer id) {
        return dispatchRepository.findById(id);
    }

    @Override
    public Dispatch updateDispatch(Integer id, Dispatch dispatch) {
        return dispatchRepository.findById(id).map(existing -> {
            existing.setBuyerName(dispatch.getBuyerName());
            existing.setBuyerDetails(dispatch.getBuyerDetails());
            existing.setDispatchVehicleNo(dispatch.getDispatchVehicleNo());
            existing.setQuantityDispatched(dispatch.getQuantityDispatched());
            existing.setSellingPricePerMt(dispatch.getSellingPricePerMt());
            existing.setDispatchDate(dispatch.getDispatchDate());
            return dispatchRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Dispatch not found with id: " + id));
    }

    @Override
    public void deleteDispatch(Integer id) {
        dispatchRepository.deleteById(id);
    }
}
