package pl.java.borowiec.user;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.java.borowiec.common.PKEntity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserRole extends PKEntity {

    private static final long serialVersionUID = 5020236122880200504L;
    @NotNull
    @Size(min = 2, max = 20)
    private String role;

}
