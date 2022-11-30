package distribuitor.itstoony.com.github.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "owner")
    private String owner;

    @Column(name = "capital")
    private Double capital;

    @OneToOne(mappedBy = "company")
    private Adress adress;

}
