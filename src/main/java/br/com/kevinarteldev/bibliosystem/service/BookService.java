package br.com.kevinarteldev.bibliosystem.service;

import br.com.kevinarteldev.bibliosystem.entity.BookEntity;
import br.com.kevinarteldev.bibliosystem.response.PageResponse;
import br.com.kevinarteldev.bibliosystem.request.BookCreateRequest;
import br.com.kevinarteldev.bibliosystem.response.BookResponse;
import br.com.kevinarteldev.bibliosystem.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final ObjectMapper objectMapper;
    private final BookRepository bookRepository;
    @Transactional
    public BookResponse create(BookCreateRequest book) {
        BookEntity bookEntity = objectMapper.convertValue(book, BookEntity.class);
        return objectMapper.convertValue(bookRepository.save(bookEntity), BookResponse.class);
    }
    public PageResponse<BookResponse> list(Integer page, Integer size){
        Sort orderBy = Sort.by("id");
        PageRequest pageRequest = PageRequest.of(page,size,orderBy);
        Page<BookEntity> repositoryPage = bookRepository.findAll(pageRequest);
        List<BookResponse> bookList = repositoryPage
                .getContent()
                .stream()
                .map(book -> objectMapper.convertValue(book, BookResponse.class))
                .toList();
        return new PageResponse<>(repositoryPage.getTotalElements(),
                repositoryPage.getTotalPages(),
                page,
                size,
                bookList);
    }
    public PageResponse<BookResponse> list(int i, int i1) {
        return new PageResponse<>();
    }
    @Transactional
    public boolean delete(Integer id){
        bookRepository.deleteById(id);
        return true;
    }
    @Transactional
    public void edit(Integer id, BookCreateRequest fonteOrigem){
    }
}
