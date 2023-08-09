package com.springframework.play.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @Column(name = "product_id")
    @SequenceGenerator(
            name = "sequence_product",
            sequenceName = "sequence_product",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_product"
    )
    private Long productId;

    @Column(name = "bar_code", nullable = false, unique = true)
    private String barCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private Float price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
