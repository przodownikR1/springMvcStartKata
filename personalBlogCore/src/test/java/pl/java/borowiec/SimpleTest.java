package pl.java.borowiec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import lombok.extern.slf4j.Slf4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.borowiec.simple.Invoice;
import pl.java.borowiec.simple.Invoices;
import pl.java.borowiec.tools.FileUtil;
import pl.java.borowiec.tools.InvoiceGenerator;

/**
 * @author przodownik
 *         Module name : personalBlogCore
 *         Creating time : 10:07:26 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:simple.xml" })
@Slf4j
public class SimpleTest {

    private final static String INVOICE_FILE = "invoice.xml";
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    private List<Invoice> invoiceList;
    private Invoices invoices;

    @Before
    public void init() {
        invoiceList = InvoiceGenerator.generate();
        invoices = new Invoices();
        invoices.setInvoices(new HashSet<>(invoiceList));
    }

    @Test
    public void shoulMarshallerWork() throws XmlMappingException, IOException {
        jaxb2Marshaller.marshal(invoices, new StreamResult(new FileWriter(INVOICE_FILE)));
        File f = new File(INVOICE_FILE);
        FileInputStream fis = new FileInputStream(f);
        FileUtil.readFile(INVOICE_FILE);
        Invoices s = (Invoices) jaxb2Marshaller.unmarshal(new StreamSource(fis));
        Assert.assertEquals(3, s.getInvoices().size());
    }
 
   
}
