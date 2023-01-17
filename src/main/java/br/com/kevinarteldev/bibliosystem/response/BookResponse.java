package br.com.kevinarteldev.bibliosystem.response;


import br.com.kevinarteldev.bibliosystem.request.BookCreateRequest;
import lombok.Data;

@Data
public class BookResponse extends BookCreateRequest {
    private Integer id;
}
