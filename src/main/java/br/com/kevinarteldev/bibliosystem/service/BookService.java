package br.com.kevinarteldev.bibliosystem.service;

import br.com.kevinarteldev.bibliosystem.response.PageResponse;
import br.com.kevinarteldev.bibliosystem.request.BookCreateRequest;
import br.com.kevinarteldev.bibliosystem.response.BookResponse;
import br.com.kevinarteldev.bibliosystem.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final ObjectMapper objectMapper;
    private final BookRepository bookRepository;
    public BookResponse create(BookCreateRequest fonteOrigem) {
        return null;
    }
    public PageResponse<BookResponse> list(int i, int i1) {
        return new PageResponse<>();
    }
    public void delete(Integer id){
    }
    public void edit(Integer id, BookCreateRequest fonteOrigem){
    }
}
