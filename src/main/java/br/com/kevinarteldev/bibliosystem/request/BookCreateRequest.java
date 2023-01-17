package br.com.kevinarteldev.bibliosystem.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookCreateRequest {
    @NotNull
    private String title;

    private String subtitle;
    @NotBlank
    private String publisher;
    @NotNull
    private Integer id_author;
    @NotNull
    private Integer id_classification;
}
