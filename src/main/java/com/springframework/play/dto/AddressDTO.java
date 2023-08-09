package com.springframework.play.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AddressDTO {

    @NotEmpty(message = "O cep deve ser informado.")
    @Pattern(regexp = "[0-9]{8}")
    private String cep;

    @NotEmpty(message = "A cidade deve ser informada.")
    private String city;

    @NotEmpty(message = "A unidade federativa deve ser informada.")
    private String uf;

    @NotEmpty(message = "A rua deve ser informada.")
    private String street;

    @NotEmpty(message = "O bairro deve ser informado.")
    private String district;

    @NotNull(message = "O número deve ser informado.")
    @Positive(message = "O número deve ser maior que 0.")
    private Integer number;

}
