package pl.java.borowiec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import lombok.extern.slf4j.Slf4j;

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
import pl.java.borowiec.simple.SimpleBean;
import pl.java.borowiec.tools.InvoiceGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:simple.xml" })
@Slf4j
public class SimpleTest {

    private final static String INVOICE_FILE = "invoice.xml";
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    private List<Invoice> invoices;

    @Before
    public void init() {
        invoices = InvoiceGenerator.generate();
    }

    @Test
    public void shoulMarshallerWork() throws XmlMappingException, IOException {
        
        jaxb2Marshaller.marshal(invoices.get(0), new StreamResult(new FileWriter(INVOICE_FILE)));

        File f = new File(INVOICE_FILE);
        FileInputStream fis = new FileInputStream(f);
        Invoice s = (Invoice) jaxb2Marshaller.unmarshal(new StreamSource(fis));
        log.info("+++      {}" + s);
    }

}
