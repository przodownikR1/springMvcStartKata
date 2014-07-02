package pl.java.borowiec.simple;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstactId {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO) //wymagane przez hibernate
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
}
