package br.com.kevinarteldev.bibliosystem;

import br.com.kevinarteldev.bibliosystem.request.ClientCreateRequest;
import br.com.kevinarteldev.bibliosystem.response.ClientResponse;
import br.com.kevinarteldev.bibliosystem.response.PageResponse;
import br.com.kevinarteldev.bibliosystem.repository.ClientRepository;
import br.com.kevinarteldev.bibliosystem.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ClientTest {
    ClientCreateRequest fonteOrigem = null;
    ClientResponse fonteDestino = null;

    @InjectMocks
    private ClientService service;
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ObjectMapper objectMapper;
    @Test
    public void testCreateClientComSucesso(){
//        fonteOrigem = mock(ClientCreateRequest.class);
//        fonteDestino = mock(ClientResponse.class);
//        Mockito.lenient().when(service.create(fonteOrigem)).thenReturn(fonteDestino);
//        ClientResponse result = service.create(fonteOrigem);
//        Assertions.assertEquals(result, fonteDestino);
//        Assertions.assertEquals(fonteOrigem.getName(),result.getName());
    }
    @Test
    public void testListClientComSucesso(){
        PageResponse<ClientResponse> pageDTO = mock(PageResponse.class);
        Mockito.lenient().when(service.list(0,10)).thenReturn(pageDTO);
        PageResponse<ClientResponse> result = service.list(0,10);
        Assertions.assertEquals(result, pageDTO);
    }
    @Test
    public void testDeleteClientComSucesso(){
        Mockito.lenient().when(service.delete(1)).thenReturn(true);
        Assertions.assertAll(
                () -> Assertions.assertEquals(service.delete(1), true)
        );
    }
}
