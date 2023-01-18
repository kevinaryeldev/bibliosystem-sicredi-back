package br.com.kevinarteldev.bibliosystem.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.util.Date;

@Data
public class ClientCreateRequest {

    private String name;

    private Integer document;

    private String email;

    private Character gender;
    
    private Date birthDate;
}
