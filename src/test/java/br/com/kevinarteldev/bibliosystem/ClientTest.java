package br.com.kevinarteldev.bibliosystem;

import br.com.kevinarteldev.bibliosystem.dto.ClientCreateDTO;
import br.com.kevinarteldev.bibliosystem.dto.ClientDTO;
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
    ClientCreateDTO fonteOrigem = null;
    ClientDTO fonteDestino = null;

    @InjectMocks
    private ClientService service;
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ObjectMapper objectMapper;

    @Test
    public void testCreateClientComSucesso(){
        fonteOrigem = mock(ClientCreateDTO.class);
        fonteDestino = mock(ClientDTO.class);
        Mockito.lenient().when(service.create(fonteOrigem)).thenReturn(fonteDestino);
        Assertions.assertAll(
                () -> Assertions.assertEquals(fonteOrigem.getName(),fonteDestino.getName())
        );
    }
}
