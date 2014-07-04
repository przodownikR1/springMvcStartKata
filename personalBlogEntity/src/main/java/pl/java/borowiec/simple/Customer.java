package pl.java.borowiec.simple;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;

    public Customer(String name) {
        super();
        this.name = name;
    }

    public Customer() {
        super();
    }
    
    
}
