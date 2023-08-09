package com.springframework.play.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @Column(name = "order_id")
    @SequenceGenerator(
            name = "sequence_order",
            sequenceName = "sequence_order",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_order"
    )
    private Long orderId;

    @Column(name = "description")
    private String description;

    @Column(name = "billed")
    private boolean billed;

    @Column(name = "billed_date")
    private Date billedDate;

    @ManyToOne(optional = false)
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "order")
    private List<OrderItens> itens;


}
