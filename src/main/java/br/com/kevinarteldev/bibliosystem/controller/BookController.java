package br.com.kevinarteldev.bibliosystem.controller;

import br.com.kevinarteldev.bibliosystem.exception.BusinessRuleException;
import br.com.kevinarteldev.bibliosystem.exception.NotFoundException;
import br.com.kevinarteldev.bibliosystem.request.BookCreateRequest;
import br.com.kevinarteldev.bibliosystem.response.BookResponse;
import br.com.kevinarteldev.bibliosystem.response.PageResponse;
import br.com.kevinarteldev.bibliosystem.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/criar")
    public ResponseEntity<BookResponse> create(@RequestBody BookCreateRequest book) throws BusinessRuleException {
        return bookService.create(book);
    }
    @GetMapping("/lista-all")
    public ResponseEntity<PageResponse<BookResponse>> list(Integer page, Integer size){
        return bookService.list(page,size);
    }
    @GetMapping("/lista/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable Integer id) throws NotFoundException {
        return bookService.findById(id);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws NotFoundException {
        return bookService.delete(id);
    }
}
