package com.nsv.supplychainmanagement.invoicewithoutgstservice.service;


import com.nsv.supplychainmanagement.invoicewithoutgstservice.model.InvoiceItem;
import com.nsv.supplychainmanagement.invoicewithoutgstservice.repository.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

    @Autowired
    private InvoiceItemRepository repository;

    @Override
    public List<InvoiceItem> getAllItems() {
        return repository.findAll();
    }

    @Override
    public InvoiceItem getItemById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public InvoiceItem createItem(InvoiceItem item) {
        return repository.save(item);
    }

    @Override
    public InvoiceItem updateItem(Integer id, InvoiceItem item) {
        item.setItemId(id);
        return repository.save(item);
    }

    @Override
    public void deleteItem(Integer id) {
        repository.deleteById(id);
    }
}
