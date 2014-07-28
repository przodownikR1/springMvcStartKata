package pl.java.borowiec.simple;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

import com.google.common.collect.Sets;

@XmlRootElement(name="invoices")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Invoices {

    @XmlElement(name = "invoices_details", required = true)
    private Set<Invoice> invoices = Sets.newHashSet();
    
  
}
