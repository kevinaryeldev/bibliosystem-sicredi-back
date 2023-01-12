package br.com.kevinarteldev.bibliosystem.service;

import br.com.kevinarteldev.bibliosystem.dto.ClientCreateDTO;
import br.com.kevinarteldev.bibliosystem.dto.ClientDTO;
import br.com.kevinarteldev.bibliosystem.dto.PageDTO;
import br.com.kevinarteldev.bibliosystem.entity.ClientEntity;
import br.com.kevinarteldev.bibliosystem.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ObjectMapper objectMapper;
    private final ClientRepository clientRepository;
    public void create(ClientCreateDTO client){
        ClientEntity clientEntity = objectMapper.convertValue(client, ClientEntity.class);
        ClientEntity clientSaved = clientRepository.save(clientEntity);
        objectMapper.convertValue(clientSaved, ClientDTO.class);
        return;
    }
//    public ClientDTO edit(Integer id, ClientCreateDTO client){
//        ClientEntity clientEntity = objectMapper.convertValue(client, ClientEntity.class);
//        clientRepository.
//    }
    public PageDTO<ClientDTO> list(Integer page, Integer size){
        Sort orderBy = Sort.by("id");
        PageRequest pageRequest = PageRequest.of(page,size,orderBy);
        Page<ClientEntity> repositoryPage = clientRepository.findAll(pageRequest);
        List<ClientDTO> clientList = repositoryPage
                .getContent()
                .stream()
                .map(client -> objectMapper.convertValue(client,ClientDTO.class))
                .toList();
        return new PageDTO<>(repositoryPage.getTotalElements(),
                repositoryPage.getTotalPages(),
                page,
                size,
                clientList);
    }
    public void delete(Integer id){
        clientRepository.deleteById(id);
    }
    public ClientDTO findById(Integer id){
        ClientEntity client = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Client not found"));
        return objectMapper.convertValue(client, ClientDTO.class);
    }
}
