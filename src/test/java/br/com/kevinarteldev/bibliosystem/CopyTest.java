package br.com.kevinarteldev.bibliosystem;

import br.com.kevinarteldev.bibliosystem.response.PageResponse;
import br.com.kevinarteldev.bibliosystem.request.CopyCreateRequest;
import br.com.kevinarteldev.bibliosystem.response.CopyResponse;
import br.com.kevinarteldev.bibliosystem.repository.CopyRepository;
import br.com.kevinarteldev.bibliosystem.service.CopyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class CopyTest {

    @Mock
    private CopyService copyService;
    @Mock
    private CopyRepository copyRepository;
    @Mock
    private ObjectMapper objectMapper;

    @Test
    public void testCreateCopyComSucesso(){
        CopyCreateRequest fonteOrigem = mock(CopyCreateRequest.class);
        CopyResponse fonteDestino = mock(CopyResponse.class);
        Mockito.lenient().when(copyService.create(fonteOrigem)).thenReturn(fonteDestino);
        CopyResponse result = copyService.create(fonteOrigem);
        Assert.assertEquals(result, fonteDestino);
    }

    @Test
    public void testListCopyComSucesso(){
        PageResponse<CopyResponse> pageDTO = mock(PageResponse.class);
        Mockito.lenient().when(copyService.list(0,10)).thenReturn(pageDTO);
        PageResponse<CopyResponse> result = copyService.list(0,10);
        Assert.assertEquals(result, pageDTO);
    }
}
