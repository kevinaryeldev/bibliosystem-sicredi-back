package br.com.kevinarteldev.bibliosystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;

@Data
public class ClientCreateDTO {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private Integer document;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private Character gender;

    @NotNull
    @NotBlank
    private Date birthDate;
}
