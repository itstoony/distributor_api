package distribuitor.itstoony.com.github.model.authentication;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@MappedSuperclass
@Table(name = "account")
@Data
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    @NotNull @NotEmpty
    private String login;

    @Column(name = "password")
    @NotNull @NotEmpty
    private String password;

}
