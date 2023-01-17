package br.com.kevinarteldev.bibliosystem.request;

import lombok.Data;

@Data
public class CopyCreateRequest {
    private Integer id_book;
    private Integer year;
    private Integer propertyCode;
    private Integer edition;
}
