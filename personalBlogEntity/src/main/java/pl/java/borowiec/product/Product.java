package pl.java.borowiec.product;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.java.borowiec.common.PKEntity;


@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@XmlRootElement(name="product")
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Product extends PKEntity{

    private static final long serialVersionUID = -4545807266661259410L;

    private String name;
    
    private BigDecimal price;

  
    
    
}
