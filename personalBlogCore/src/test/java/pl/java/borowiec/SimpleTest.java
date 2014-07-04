package pl.java.borowiec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.borowiec.simple.SimpleBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:simple.xml" })
@Slf4j
public class SimpleTest {

    @Autowired 
    private ApplicationContext applicationContext;
    
    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;
    
    @Test
    public void shouldBootstrapLoaded() throws InterruptedException, XmlMappingException, IOException{       
        SimpleBean sb = new SimpleBean();
        sb.setUserHome("borowiec");
       
        
        sb.setName("bartek");
        jaxb2Marshaller.marshal(sb,new StreamResult(new FileWriter("simple.xml")));
       
        File f = new File("simple.xml");
        FileInputStream fis = new FileInputStream(f);
        SimpleBean s = (SimpleBean)jaxb2Marshaller.unmarshal(new StreamSource(fis));
        log.info("+++      {}" +s);
    }
    
}
