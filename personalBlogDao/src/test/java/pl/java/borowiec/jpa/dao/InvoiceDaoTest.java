package pl.java.borowiec.jpa.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import lombok.extern.slf4j.Slf4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.common.dao.jpa.invoice.InvoiceDTO;
import pl.java.borowiec.common.dao.jpa.invoice.InvoiceDao;
import pl.java.borowiec.product.Product;
import pl.java.borowiec.simple.Customer;
import pl.java.borowiec.simple.Invoice;
import pl.java.borowiec.simple.InvoiceType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao.xml" })
@Transactional
@ActiveProfiles("jpa")
@Slf4j
public class InvoiceDaoTest {

    @Autowired
    private InvoiceDao invoiceDao;

    private Invoice invoice;

    private Customer customer;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Before
    public void before() {

        Product p1 = new Product();
        p1.setName("hammer");
        p1.setPrice(new BigDecimal("20"));

        Product p2 = new Product();
        p2.setName("table");
        p2.setPrice(new BigDecimal("400"));

        customer = new Customer("slawek");

        invoice = new Invoice();

        invoice.setCustomer(customer);
        invoice.setAmount(new BigDecimal("99"));

        try {
            invoice.setCreataDate(sdf.parse("1999-10-01"));
        } catch (ParseException e) {
        }

        try {
            invoice.setPayDate(sdf.parse("2014-08-01"));
        } catch (ParseException e) {
        }

        invoice.setDescription("description.....");
        invoice.setPaid(true);
        invoice.setType(InvoiceType.BUSINESS);
        invoice.setUser("slawek borowiec");
        invoice.setName("computers");

        invoice.getProducts().add(p1);
        invoice.getProducts().add(p2);
    }

    @Test
    public void shouldWork() throws InterruptedException {
        invoiceDao.save(invoice);
     
        Invoice invoice = invoiceDao.getAll().get(0);
       
        log.info(" !!!!!!  {}" ,invoiceDao.getInvoiceByCustomer(customer,new BigDecimal("99")).get(0));
   
        log.info("  +++   {}", invoice.getProducts());
        
        log.info("  namedQueryTEst :  {} " ,invoiceDao.findInvoiceByUser("slawek borowiec",0,2));
        
        InvoiceDTO invoiceDTO = invoiceDao.getInfoAboutUserAndProductCount("slawek borowiec");
      
    }

}
