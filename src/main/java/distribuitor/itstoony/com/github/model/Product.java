package distribuitor.itstoony.com.github.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Category name shouldn't be empty")
    private String name;

    @NotEmpty(message = "Category description shouldn't be empty")
    private String description;

    @NotEmpty(message = "Category value shouldn't be empty")
    private Double value;

    @OneToMany(mappedBy = "product")
    private List<ItemsOrders> order = new ArrayList<>();

    @ManyToOne
    private Deposit deposit;

    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> category = new ArrayList<>();

}
