package distribuitor.itstoony.com.github.model.authentication;

import distribuitor.itstoony.com.github.model.Admin;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AdminAccount extends Account implements Authenticable {

    @OneToOne
    private Admin admin;

}
