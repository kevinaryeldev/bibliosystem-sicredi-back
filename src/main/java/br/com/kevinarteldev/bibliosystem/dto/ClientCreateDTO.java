package br.com.kevinarteldev.bibliosystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.util.Date;

@Data
public class ClientCreateDTO {

    @NotBlank
    private String name;

    @Positive
    private Integer document;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private Character gender;

    @NotNull
    private Date birthDate;
}
