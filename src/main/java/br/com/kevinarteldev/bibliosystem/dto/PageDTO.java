package br.com.kevinarteldev.bibliosystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO<T> {
    private Long totalElements;
    private Integer pageQuantity;
    private Integer page;
    private Integer size;
    private List<T> elements;
}
