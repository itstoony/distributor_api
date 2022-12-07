package distribuitor.itstoony.com.github.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
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
    @JoinColumn(name = "clients_id")
    private Costumer costumer;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<ItemsOrders> items = new ArrayList<>();

    public Orders(Costumer client){
        this.costumer = client;
        this.orderDate = LocalDate.now();
        this.totalValue = 0.0;
    }

}
