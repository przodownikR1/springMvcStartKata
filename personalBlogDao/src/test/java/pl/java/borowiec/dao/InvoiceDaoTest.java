package pl.java.borowiec.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

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

import pl.java.borowiec.dao.invoice.InvoiceDao;
import pl.java.borowiec.simple.Customer;
import pl.java.borowiec.simple.Invoice;
import pl.java.borowiec.simple.InvoiceType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao.xml" })
@ActiveProfiles("spring-data-test")
// niewazne poki co - profile beda potem
@Transactional
// rollback po skonczonym tescie
@Slf4j
public class InvoiceDaoTest {

    @Autowired
    private InvoiceDao invoiceDao;

    private Invoice invoice;

    private Customer customer;

    @Before
    public void before() {
        customer = new Customer("slawek");
        invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setAmount(new BigDecimal("99"));

        invoice.setCreataDate(LocalDate.parse("1999-10-01"));

        invoice.setPayDate(LocalDate.parse("2014-08-01"));

        invoice.setDescription("description.....");
        invoice.setPaid(true);
        invoice.setType(InvoiceType.BUSINESS);
        invoice.setUser("slawek borowiec");
        invoice.setName("computers");
    }

    @Test
    public void shouldBootstrap() {
        Assert.assertNotNull(invoiceDao);
        Assert.assertEquals(0, invoiceDao.count());
        invoiceDao.save(invoice);
        Assert.assertEquals(1, invoiceDao.count());
        List<Invoice> list = invoiceDao.findAll();
        list.forEach(i -> System.out.println("value : " + i));
        // update test
        invoice.setName("pens");
        Invoice saved = invoiceDao.save(invoice);
        Assert.assertEquals(invoice, invoiceDao.findByName("pens"));
        Assert.assertEquals("pens", invoiceDao.findAll().get(0).getName());
        invoiceDao.delete(invoice); // delete test
        Assert.assertEquals(0, invoiceDao.count());

        log.info("+++++   {}", invoice);

    }
}
