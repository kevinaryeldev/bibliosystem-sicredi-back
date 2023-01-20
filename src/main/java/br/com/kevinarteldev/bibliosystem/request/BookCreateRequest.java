package br.com.kevinarteldev.bibliosystem.request;

import lombok.Data;

@Data
public class BookCreateRequest {

    private String title;

    private Integer code;

    private String subtitle;

    private String publisher;

    private Integer id_author;

    private Integer id_classification;
}
