package com.springframework.play.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "warehouse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse {

    @Id
    @Column(name = "warehouse_id")
    @SequenceGenerator(
            name = "sequence_warehouse",
            sequenceName = "sequence_warehouse",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_warehouse"
    )
    private Long warehouseId;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(optional = false)
    private Product product;

}
