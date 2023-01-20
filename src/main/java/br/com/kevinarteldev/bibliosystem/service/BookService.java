package br.com.kevinarteldev.bibliosystem.service;

import br.com.kevinarteldev.bibliosystem.entity.BookEntity;
import br.com.kevinarteldev.bibliosystem.entity.ClientEntity;
import br.com.kevinarteldev.bibliosystem.exception.BusinessRuleException;
import br.com.kevinarteldev.bibliosystem.exception.NotFoundException;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final ObjectMapper objectMapper;
    private final BookRepository bookRepository;

    private void validateCode(Integer code) throws BusinessRuleException {
        if (code == null || code.intValue() <= 0) {
            throw new BusinessRuleException("Erro no campo code");
        }
    }

    private void validateTitle(String title) throws BusinessRuleException {
        if (title.isBlank() || title.isEmpty()) {
            throw new BusinessRuleException("Erro no campo title");
        }
    }

    private void validateAuthor(Integer id_author) throws BusinessRuleException {

    }
    private void validateClassification(Integer id_classification) throws BusinessRuleException {

    }
    private void validatePublisher(String publisher) throws BusinessRuleException {
        if (publisher.isBlank() || publisher.isEmpty() || publisher.length() < 3) {
            throw new BusinessRuleException("Erro no campo publisher");
        }
    }

    private BookEntity getBookById(Integer id) throws NotFoundException {
        Optional<BookEntity> bookOpt = bookRepository.findById(id);
        if(!bookOpt.isPresent()){
            throw new NotFoundException("Cliente não encontrado");
        }
        return bookOpt.get();
    }
    @Transactional
    public ResponseEntity<BookResponse> create(BookCreateRequest book) throws BusinessRuleException {
        validateTitle(book.getTitle());
        validatePublisher(book.getPublisher());
        validateCode(book.getCode());
        validateAuthor(book.getId_author());
        validateClassification(book.getId_classification());
        BookEntity bookEntity = objectMapper.convertValue(book, BookEntity.class);
        BookResponse bookResponse = objectMapper.convertValue(bookRepository.save(bookEntity), BookResponse.class);
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }
    public ResponseEntity<PageResponse<BookResponse>> list(Integer page, Integer size){
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        Sort orderBy = Sort.by("id");
        PageRequest pageRequest = PageRequest.of(page,size,orderBy);
        Page<BookEntity> repositoryPage = bookRepository.findAll(pageRequest);
        List<BookResponse> bookList = repositoryPage
                .getContent()
                .stream()
                .map(book -> objectMapper.convertValue(book, BookResponse.class))
                .toList();
        PageResponse<BookResponse> pageResponse = new PageResponse<>(repositoryPage.getTotalElements(),
                repositoryPage.getTotalPages(),
                page,
                size,
                bookList);
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }
    public ResponseEntity<BookResponse> findById(Integer id) throws NotFoundException {
        BookEntity bookEntity = getBookById(id);
        BookResponse bookResponse = objectMapper.convertValue(bookEntity, BookResponse.class);
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<Void> delete(Integer id) throws NotFoundException {
        getBookById(id);
        bookRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
