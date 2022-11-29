package distribuitor.itstoony.com.github.model;

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

    private LocalDate orderDate;

    private Double totalValue;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Clients clients;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<ItemsOrders> items = new ArrayList<>();


}
