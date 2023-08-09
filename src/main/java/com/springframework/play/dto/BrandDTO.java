package com.springframework.play.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BrandDTO {

    @NotEmpty(message = "O nome da marca deve ser informado.")
    private String name;

}
