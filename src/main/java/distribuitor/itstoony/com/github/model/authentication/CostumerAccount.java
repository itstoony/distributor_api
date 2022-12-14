package distribuitor.itstoony.com.github.model.authentication;

import distribuitor.itstoony.com.github.model.Costumer;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CostumerAccount extends Account {

    @OneToOne
    private Costumer costumer;

    public CostumerAccount(String login, String password) {
        super.setLogin(login);
        super.setPassword(password);
    }
}
