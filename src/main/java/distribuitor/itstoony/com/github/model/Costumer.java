package distribuitor.itstoony.com.github.model;

import distribuitor.itstoony.com.github.model.authentication.CostumerAccount;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import java.time.LocalDate;

@Entity
@Data
@Builder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "costumer")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name shouldn't be empty")
    @Column(name = "name")
    private String name;

    @CPF
    @Column(name = "cpf")
    private String cpf;

    @Email
    @Column(name = "email")
    private String email;

    @OneToOne
    private CostumerAccount account;

    private LocalDate registrationDate;

    @OneToOne(mappedBy = "costumer")
    private Address address;

}
