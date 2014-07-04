package pl.java.borowiec.common.dao.jpa.invoice.impl;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.common.dao.jpa.AbstractJpaDao;
import pl.java.borowiec.common.dao.jpa.invoice.InvoiceDao;
import pl.java.borowiec.simple.Invoice;


@Repository("invoiceDao")
@Profile("jpa")
public class InvoiceDaoImpl extends AbstractJpaDao<Invoice> implements InvoiceDao {

    public InvoiceDaoImpl() {
        super(Invoice.class);
    }

    @Override
    public List<Invoice> getInvoiceByName(String name) {
        List<Invoice> result =  em.createQuery("From Invoice inv where inv.name  =:name ", Invoice.class).setParameter("name", name).getResultList();
        return result;
    }

}
