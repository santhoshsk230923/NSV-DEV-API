package com.nsv.supplychainmanagement.invoicewithoutgstservice.service;

import com.nsv.supplychainmanagement.invoicewithoutgstservice.model.InvoiceItem;

import java.util.List;

public interface InvoiceItemService {
    List<InvoiceItem> getAllItems();
    InvoiceItem getItemById(Integer id);
    InvoiceItem createItem(InvoiceItem item);
    InvoiceItem updateItem(Integer id, InvoiceItem item);
    void deleteItem(Integer id);
}
