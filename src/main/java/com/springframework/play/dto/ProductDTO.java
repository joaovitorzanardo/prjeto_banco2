package com.springframework.play.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductDTO {

    @NotEmpty(message = "O código de barras deve ser informado.")
    private String barCode;

    @NotEmpty(message = "O nome do produto deve ser informado.")
    private String name;

    @PositiveOrZero(message = "O preço não pode ser negativo.")
    private Float price = 0.0F;

    @NotNull(message = "A marca do produto deve ser informada.")
    @Positive
    private Long brandId;

}
