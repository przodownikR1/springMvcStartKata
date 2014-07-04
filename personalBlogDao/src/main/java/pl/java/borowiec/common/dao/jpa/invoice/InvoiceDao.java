package pl.java.borowiec.common.dao.jpa.invoice;

import java.util.List;

import pl.java.borowiec.simple.Invoice;

public interface InvoiceDao {
    void save(Invoice invoice);

    void remove(Invoice invoice );

    Invoice  findById(Long id);

    List<Invoice> getInvoiceByName(String name);

    List<Invoice> getAll();

    long countAll();
}
