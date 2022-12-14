package distribuitor.itstoony.com.github.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "depositProduct")
public class DepositProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unitValue")
    private Double unitValue;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "totalValue")
    private Double totalValue;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "deposit_id")
    private Deposit deposit;

}
