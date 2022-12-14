package distribuitor.itstoony.com.github.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    private LocalDate orderDate;

    @JsonIgnore
    private Double totalValue;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<ItemsOrders> items = new ArrayList<>();

    public Orders(Costumer client){
        this.costumer = client;
        this.orderDate = LocalDate.now();
        this.totalValue = 0.0;
    }

}
