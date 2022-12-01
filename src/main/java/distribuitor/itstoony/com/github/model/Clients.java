package distribuitor.itstoony.com.github.model;

//import distribuitor.itstoony.com.github.model.address.ResidencialAddress;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name shouldn't be empty")
    private String name;

    @CPF
    private String cpf;

    private LocalDate dataDeCadastro;

    @OneToOne(mappedBy = "clients")
    private Address address;

}
