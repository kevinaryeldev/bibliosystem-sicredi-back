package br.com.kevinarteldev.bibliosystem;

import br.com.kevinarteldev.bibliosystem.repository.BookRepository;
import br.com.kevinarteldev.bibliosystem.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class BookTest {
    @Mock
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private ObjectMapper objectMapper;

    @Test
    public void testCreateBookComSucesso(){
//        BookCreateRequest fonteOrigem = mock(BookCreateRequest.class);
//        BookResponse fonteDestino = mock(BookResponse.class);
//        Mockito.lenient().when(bookService.create(fonteOrigem)).thenReturn(fonteDestino);
//        BookResponse result = bookService.create(fonteOrigem);
//        Assert.assertEquals(result, fonteDestino);
    }

    @Test
    public void testListBookComSucesso(){
//        PageResponse<BookResponse> pageDTO = mock(PageResponse.class);
//        when(bookService.list(0,10)).thenReturn(pageDTO);
//        PageResponse<BookResponse> result = bookService.list(0,10);
//        Assert.assertEquals(result, pageDTO);
    }
    @Test
    public void testDeleteBookComSucesso(){
//        bookService.delete(1);
    }
}
