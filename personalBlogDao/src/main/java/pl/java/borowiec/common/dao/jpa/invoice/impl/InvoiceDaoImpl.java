package pl.java.borowiec.common.dao.jpa.invoice.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.common.dao.jpa.AbstractJpaDao;
import pl.java.borowiec.common.dao.jpa.invoice.InvoiceDTO;
import pl.java.borowiec.common.dao.jpa.invoice.InvoiceDao;
import pl.java.borowiec.simple.Customer;
import pl.java.borowiec.simple.Invoice;


@Repository("invoiceDao")
@Profile("jpa")
public class InvoiceDaoImpl extends AbstractJpaDao<Invoice> implements InvoiceDao {

    public InvoiceDaoImpl() {
        super(Invoice.class);
    }

    @Override
    public List<Invoice> getInvoiceByName(String name) {
        List<Invoice> result = 
                em.createQuery("FROM Invoice inv WHERE inv.name  =:name ", Invoice.class).setParameter("name", name).getResultList();
        return result;
    }

    @Override
    public List<Invoice> getInvoiceByCustomer(Customer customer,BigDecimal amount) {
        
        List<Invoice> result = 
                em.createQuery("FROM Invoice inv WHERE inv.customer  =:customer  AND inv.amount =:a"
                        , Invoice.class)
                        .setParameter("customer",customer)
                        .setParameter("a", amount)
                        .getResultList();
        return result;
    }

    @Override
    public List<Invoice> findInvoiceByUser(String user,int startPage , int pageSize) {
        TypedQuery<Invoice> query = em.createNamedQuery("Invoice.findByUser", Invoice.class);
        query.setParameter("user", user);
        query.setFirstResult(startPage);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

      
  
    
    @Override
    public InvoiceDTO getInfoAboutUserAndProductCount(String userName) {
        Query query  = em.createNativeQuery("select amount , user, invoice_name  from simple_invoice");
        List<Object[]> results = query.getResultList();
        System.err.println(results);
     
       return new InvoiceDTO();
    }

    
    
}
