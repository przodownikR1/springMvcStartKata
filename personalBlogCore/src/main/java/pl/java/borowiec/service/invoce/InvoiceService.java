package pl.java.borowiec.service.invoce;

import java.util.List;

import pl.java.borowiec.simple.Invoice;

public interface InvoiceService {
    Invoice findById(Long id);
    Invoice findByName(String name);
    List<Invoice> getList();
    Invoice save(Invoice invoice);
    void delete(Invoice invoice);
}
