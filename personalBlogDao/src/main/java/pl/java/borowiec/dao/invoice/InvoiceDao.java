package pl.java.borowiec.dao.invoice;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.borowiec.simple.Invoice;
//  <jpa:repositories base-package="pl.java.borowiec.dao" />

public interface InvoiceDao extends JpaRepository<Invoice, Long>{
   
    //@Query("from Invoice invoice where invoice.name = ?") //hql
    
    Invoice findByName(String name);
}
