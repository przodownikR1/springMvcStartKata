package pl.java.borowiec.service.invoce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.dao.invoice.InvoiceDao;
import pl.java.borowiec.service.invoce.InvoiceService;
import pl.java.borowiec.simple.Invoice;

@Service  //to metody biznesowy i transakcyjnosc = skupia dao do siebie tak aby zapewnic transakcje
@Transactional(readOnly = true)
public class InvoiceServiceImpl implements InvoiceService {

    
    private InvoiceDao invoiceDao;
    
    @Autowired
    public InvoiceServiceImpl(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
      
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceDao.findOne(id);
    }

    @Override
    public Invoice findByName(String name) {
        return invoiceDao.findByName(name);
    }

    @Override
    public List<Invoice> getList() {
        return invoiceDao.findAll();
    }

    @Override
    @Transactional
    public Invoice save(Invoice invoice) {
        return invoiceDao.save(invoice);
    }

    @Override
    @Transactional
    public void delete(Invoice invoice) {
        invoiceDao.delete(invoice);

    }
    
    @Override
    @Transactional
    public void deleteAll() {
        invoiceDao.deleteAll();
        
    }

}
