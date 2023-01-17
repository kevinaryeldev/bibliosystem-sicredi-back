package br.com.kevinarteldev.bibliosystem.service;

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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ObjectMapper objectMapper;
    private final ClientRepository clientRepository;
    @Transactional
    public ClientResponse create(ClientCreateRequest client){
        ClientEntity clientEntity = objectMapper.convertValue(client, ClientEntity.class);
        ClientEntity clientSaved = clientRepository.save(clientEntity);
        return objectMapper.convertValue(clientSaved, ClientResponse.class);
    }
    @Transactional
    public ClientResponse edit(Integer id, ClientEditRequest client){
        Optional<ClientEntity> clientOpt = clientRepository.findById(id);
        if(clientOpt.isPresent()){
            ClientEntity clientSaved = clientOpt.get();
            clientSaved.setEmail(client.getEmail());
            clientSaved.setGender(client.getGender());
            return objectMapper.convertValue(clientRepository.save(clientSaved), ClientResponse.class);
        }
        return null;
    }
    public PageResponse<ClientResponse> list(Integer page, Integer size){
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
    public void delete(Integer id){
        clientRepository.deleteById(id);
    }
    public ClientResponse findById(Integer id){
        ClientEntity client = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Client not found"));
        return objectMapper.convertValue(client, ClientResponse.class);
    }
}
