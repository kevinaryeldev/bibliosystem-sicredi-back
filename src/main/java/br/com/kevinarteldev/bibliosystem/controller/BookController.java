package br.com.kevinarteldev.bibliosystem.controller;

import br.com.kevinarteldev.bibliosystem.request.BookCreateRequest;
import br.com.kevinarteldev.bibliosystem.response.BookResponse;
import br.com.kevinarteldev.bibliosystem.response.PageResponse;
import br.com.kevinarteldev.bibliosystem.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookCreateRequest book){
        return new ResponseEntity<>(bookService.create(book),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<PageResponse<BookResponse>> list(Integer page, Integer size){
        return new ResponseEntity<>(bookService.list(page,size), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
