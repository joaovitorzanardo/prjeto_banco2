package com.springframework.play.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CustomerDTO {

    @NotEmpty(message = "O primeiro nome deve ser informado.")
    private String firstName;

    @NotEmpty(message = "O último nome deve ser informado.")
    private String lastName;

    @NotEmpty(message = "O email deve ser informado.")
    @Email(message = "Formato de email inválido.")
    private String email;

    @NotEmpty(message = "O cpf deve ser informado.")
    private String cpf;

    @NotEmpty(message = "O telefone deve ser informado")
    private String phoneNumber;

    @NotNull(message = "O endereço deve ser informado.")
    @Positive
    private Long addressId;

}
