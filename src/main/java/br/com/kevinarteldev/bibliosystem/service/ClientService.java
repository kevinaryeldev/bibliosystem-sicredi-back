package br.com.kevinarteldev.bibliosystem.service;

import br.com.kevinarteldev.bibliosystem.exception.BusinessRuleException;
import br.com.kevinarteldev.bibliosystem.request.ClientCreateRequest;
import br.com.kevinarteldev.bibliosystem.request.ClientEditRequest;
import br.com.kevinarteldev.bibliosystem.response.ClientResponse;
import br.com.kevinarteldev.bibliosystem.response.PageResponse;
import br.com.kevinarteldev.bibliosystem.entity.ClientEntity;
import br.com.kevinarteldev.bibliosystem.repository.ClientRepository;
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
public class ClientService {
    private final ObjectMapper objectMapper;
    private final ClientRepository clientRepository;
    @Transactional
    public ResponseEntity<ClientResponse> create(ClientCreateRequest client) throws BusinessRuleException {
        if (client.getName().isBlank() || client.getName().isEmpty() || client.getName().length() < 5 || !client.getName().matches("[A-Za-zÀ-ȕ ]")) {
            throw new BusinessRuleException("Erro no nome do cliente");
        }
        if (client.getDocument() == null || client.getDocument().intValue() <= 0) {
            throw new BusinessRuleException("Erro no campo document");
        }
        if (client.getEmail().isBlank() || client.getEmail().isEmpty() || !client.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$" ) {
            throw new BusinessRuleException("Erro no campo email");
        }
        if (client.getGender() == null || client.getGender() != 'M' && client.getGender() != 'F' && client.getGender() != 'O' ) {
            throw new BusinessRuleException("Erro no campo gender");
        }
        ClientEntity clientEntity = objectMapper.convertValue(client, ClientEntity.class);
        ClientEntity clientSaved = clientRepository.save(clientEntity);
        ClientResponse clientResponse = objectMapper.convertValue(clientSaved, ClientResponse.class);
        return new ResponseEntity<>(clientResponse,HttpStatus.CREATED);
    }
    @Transactional
    public ClientResponse edit(Integer id, ClientEditRequest client){
        Optional<ClientEntity> clientOpt = clientRepository.findById(id);
        if(!clientOpt.isPresent()){
            throw new IllegalArgumentException();
        }
        ClientEntity clientSaved = clientOpt.get();
        clientSaved.setEmail(client.getEmail());
        clientSaved.setGender(client.getGender());
        return objectMapper.convertValue(clientRepository.save(clientSaved), ClientResponse.class);
    }
    public PageResponse<ClientResponse> list(Integer page, Integer size){
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        Sort orderBy = Sort.by("id");
        PageRequest pageRequest = PageRequest.of(page,size,orderBy);
        Page<ClientEntity> repositoryPage = clientRepository.findAll(pageRequest);
        List<ClientResponse> clientList = repositoryPage
                .getContent()
                .stream()
                .map(client -> objectMapper.convertValue(client, ClientResponse.class))
                .toList();
        return new PageResponse<>(repositoryPage.getTotalElements(),
                repositoryPage.getTotalPages(),
                page,
                size,
                clientList);
    }
    @Transactional
    public boolean delete(Integer id){
        clientRepository.deleteById(id);
        return true;
    }
    public ClientResponse findById(Integer id){
        ClientEntity client = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Client not found"));
        return objectMapper.convertValue(client, ClientResponse.class);
    }
}
