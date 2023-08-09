package com.springframework.play.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "brand")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand {

    @Id
    @Column(name = "brand_id")
    @SequenceGenerator(
            name = "sequence_brand",
            sequenceName = "sequence_brand",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_brand"
    )
    private Long brandId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
