package br.com.kevinarteldev.bibliosystem.service;

import br.com.kevinarteldev.bibliosystem.exception.BusinessRuleException;
import br.com.kevinarteldev.bibliosystem.exception.NotFoundException;
import br.com.kevinarteldev.bibliosystem.request.ClientCreateRequest;
import br.com.kevinarteldev.bibliosystem.request.ClientEditRequest;
import br.com.kevinarteldev.bibliosystem.response.ClientResponse;
import br.com.kevinarteldev.bibliosystem.response.PageResponse;
import br.com.kevinarteldev.bibliosystem.entity.ClientEntity;
import br.com.kevinarteldev.bibliosystem.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ObjectMapper objectMapper;
    private final ClientRepository clientRepository;

    private void validateEmail(String email) throws BusinessRuleException {
        if (email.isBlank() || !email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$" )){
            throw new BusinessRuleException("Erro no campo email");
        }
    }
    private void validateName(String name) throws BusinessRuleException {
        if ( name.isBlank() || name.length() < 10 || !name.matches("[A-Za-zÀ-ȕ ]")){
            throw new BusinessRuleException("Erro no nome do cliente");
        }
    }
    private void validateGender(Character gender) throws BusinessRuleException {
        if(gender == null || (gender != 'M' && gender != 'F' && gender != 'O' )){
            throw new BusinessRuleException("Erro no campo gender");
        }
    }
    private ClientEntity getClientById(Integer id) throws NotFoundException {
        Optional<ClientEntity> clientOpt = clientRepository.findById(id);
        if(clientOpt.isEmpty()){
            throw new NotFoundException("Cliente não encontrado");
        }
        return clientOpt.get();
    }

    @Transactional
    public ResponseEntity<ClientResponse> create(ClientCreateRequest client) throws BusinessRuleException {
        validateName(client.getName());
        if (client.getDocument() == null || client.getDocument() <= 0) {
            throw new BusinessRuleException("Erro no campo document");
        }
        validateEmail(client.getEmail());
        validateGender(client.getGender());
        ClientEntity clientEntity = objectMapper.convertValue(client, ClientEntity.class);
        ClientEntity clientSaved = clientRepository.save(clientEntity);
        ClientResponse clientResponse = objectMapper.convertValue(clientSaved, ClientResponse.class);
        return new ResponseEntity<>(clientResponse,HttpStatus.CREATED);
    }
    @Transactional
    public ResponseEntity<ClientResponse> edit(Integer id, ClientEditRequest client) throws NotFoundException, BusinessRuleException {
        ClientEntity clientSaved = getClientById(id);
        validateName(client.getName());
        validateEmail(client.getEmail());
        validateGender(client.getGender());
        clientSaved.setEmail(client.getEmail());
        clientSaved.setGender(client.getGender());
        ClientResponse clientResponse = objectMapper.convertValue(clientRepository.save(clientSaved), ClientResponse.class);
        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
    }
    public ResponseEntity<PageResponse<ClientResponse>> list(Integer page, Integer size){
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        Sort orderBy = Sort.by("id");
        PageRequest pageRequest = PageRequest.of(page,size,orderBy);
        Page<ClientEntity> repositoryPage = clientRepository.findAll(pageRequest);
        if (repositoryPage.getTotalElements() == 0){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        List<ClientResponse> clientList = repositoryPage
                .getContent()
                .stream()
                .map(client -> objectMapper.convertValue(client, ClientResponse.class))
                .toList();
        PageResponse<ClientResponse> pageResponse = new PageResponse<>(repositoryPage.getTotalElements(),
                repositoryPage.getTotalPages(),
                page,
                size,
                clientList);
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<Void> delete(Integer id) throws NotFoundException {
        getClientById(id);
        clientRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<ClientResponse> findById(Integer id) throws NotFoundException {
        Optional<ClientEntity> clientOpt = clientRepository.findById(id);
        if (clientOpt.isEmpty()){
            throw new NotFoundException("Cliente não encontrado.");
        }
        ClientEntity client = clientOpt.get();
        ClientResponse clientResponse = objectMapper.convertValue(client, ClientResponse.class);
        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
    }
}
