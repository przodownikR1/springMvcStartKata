package pl.java.borowiec.product;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.java.borowiec.common.PKEntity;


@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Product extends PKEntity{

    private static final long serialVersionUID = -4545807266661259410L;

    private String name;
    
    private BigDecimal price;

  
    
    
}
