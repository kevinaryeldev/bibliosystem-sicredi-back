package br.com.kevinarteldev.bibliosystem;

import br.com.kevinarteldev.bibliosystem.exception.BusinessRuleException;
import br.com.kevinarteldev.bibliosystem.exception.NotFoundException;
import br.com.kevinarteldev.bibliosystem.request.ClientCreateRequest;
import br.com.kevinarteldev.bibliosystem.repository.ClientRepository;
import br.com.kevinarteldev.bibliosystem.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ClientTest {
    ClientCreateRequest fonteOrigem = null;

    @InjectMocks
    private ClientService service;
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ObjectMapper objectMapper;
    @Test
    public void testCreateClientComSucesso() throws BusinessRuleException {
//        fonteOrigem = mock(ClientCreateRequest.class);
//        ResponseEntity<ClientResponse> fonteDestino = mock(ResponseEntity.class);
//        Mockito.lenient().when(service.create(fonteOrigem)).thenReturn(fonteDestino);
//        ResponseEntity<ClientResponse> result = service.create(fonteOrigem);
//        Assertions.assertEquals(result, fonteDestino);
//        Assertions.assertEquals(fonteOrigem.getName(),result.getBody().getName());
    }
    @Test
    public void testListClientComSucesso(){
//        ResponseEntity<PageResponse<ClientResponse>> response = mock(ResponseEntity.class);
//        Mockito.lenient().when(service.list(0,10)).thenReturn(response);
//        ResponseEntity<PageResponse<ClientResponse>> result = service.list(0,10);
//        Assertions.assertEquals(result, response);
    }
    @Test
    public void testDeleteClientComSucesso() throws NotFoundException, BusinessRuleException {
//        fonteOrigem = mock(ClientCreateRequest.class);
//        ResponseEntity<ClientResponse> fonteDestino = mock(ResponseEntity.class);
//        Mockito.lenient().when(service.create(fonteOrigem)).thenReturn(fonteDestino);
//        ResponseEntity<ClientResponse> resultCreate = service.create(fonteOrigem);
//        ResponseEntity<Void> response = mock(ResponseEntity.class);
//        Integer id = resultCreate.getBody().getId().intValue();
//        Mockito.lenient().when(service.delete(id)).thenReturn(response);
//        ResponseEntity<Void> result = service.delete(id);
//        Assertions.assertAll(
//            () -> Assertions.assertEquals(response, result),
//            () -> Assertions.assertEquals(204,result.getStatusCode())
//        );
    }
}
