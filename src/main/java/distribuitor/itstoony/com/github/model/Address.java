package distribuitor.itstoony.com.github.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import distribuitor.itstoony.com.github.model.enums.AddressType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "address")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "city")
    private String city;

    @Column(name = "states")
    private String states;

    @Column(name = "zipcode")
    private String zipcode;

    @JsonIgnore
    @OneToOne
    private Clients clients;

    @JsonIgnore
    @OneToOne
    private Deposit deposit;


    @JsonIgnore
    @OneToOne
    private Company company;


    @JsonIgnore
    private AddressType addressType;
}
