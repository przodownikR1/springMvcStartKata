package pl.java.borowiec.simple;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.java.borowiec.common.AbstactId;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends AbstactId {

    private static final long serialVersionUID = -8318278826285163158L;
    private String name;

}
