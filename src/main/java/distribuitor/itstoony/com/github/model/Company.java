package distribuitor.itstoony.com.github.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name shouldn't be empty")
    @Column(name = "name")
    private String nome;

    @NotEmpty(message = "cnpj shouldn't be empty")
    @Column(name = "cnpj")
    @CNPJ
    private String cnpj;

    @NotEmpty(message = "owner shouldn't be empty")
    @Column(name = "owner")
    private String owner;

    @NotNull(message = "capital shouldn't be empty")
    @Column(name = "capital")
    private Double capital;

    @Column(name = "registrationDate")
    private LocalDate regstrationDate;

    @OneToOne(mappedBy = "company")
    private Address address;

}
