package distribuitor.itstoony.com.github.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//TODO: Complement class
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "deposit", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<DepositProduct> products = new ArrayList<>();


    @OneToOne(mappedBy = "deposit")
    private Address address;

    public void setProducts(List<DepositProduct> products) {
        this.products = products;
    }

}
