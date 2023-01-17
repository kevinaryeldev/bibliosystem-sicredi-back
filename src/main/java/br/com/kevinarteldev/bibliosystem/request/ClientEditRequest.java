package br.com.kevinarteldev.bibliosystem.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class ClientEditRequest {

    @NotBlank
    @Email
    private String email;

    @NotNull
    private Character gender;
}
