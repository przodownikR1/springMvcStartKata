package pl.java.borowiec.common.dao.jpa.invoice;

import java.math.BigDecimal;
import java.util.List;

import pl.java.borowiec.simple.Customer;
import pl.java.borowiec.simple.Invoice;

public interface InvoiceDao {
    void save(Invoice invoice);

    void remove(Invoice invoice );

    Invoice  findById(Long id);

    List<Invoice> getInvoiceByName(String name);

    List<Invoice> getAll();

    long countAll();
    
    List<Invoice> getInvoiceByCustomer(Customer customer,BigDecimal amount);
    
    List<Invoice> findInvoiceByUser(String user, int startPage , int pageSize);
    
    InvoiceDTO getInfoAboutUserAndProductCount(String userName);
    

    
}
