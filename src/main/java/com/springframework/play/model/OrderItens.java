package com.springframework.play.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_itens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItens {

    @Id
    @Column(name = "order_itens_id")
    @SequenceGenerator(
            name = "sequence_order_itens",
            sequenceName = "sequence_order_itens",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_order_itens"
    )
    private Long orderItensId;

    @ManyToOne(optional = false)
    private Order order;

    @ManyToOne(optional = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;


}
