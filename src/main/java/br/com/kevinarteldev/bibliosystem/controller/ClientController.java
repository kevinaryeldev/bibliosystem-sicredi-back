package br.com.kevinarteldev.bibliosystem.controller;

import br.com.kevinarteldev.bibliosystem.exception.BusinessRuleException;
import br.com.kevinarteldev.bibliosystem.exception.NotFoundException;
import br.com.kevinarteldev.bibliosystem.request.ClientCreateRequest;
import br.com.kevinarteldev.bibliosystem.request.ClientEditRequest;
import br.com.kevinarteldev.bibliosystem.response.ClientResponse;
import br.com.kevinarteldev.bibliosystem.response.PageResponse;
import br.com.kevinarteldev.bibliosystem.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Validated
@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("/lista-all")
    public ResponseEntity<PageResponse<ClientResponse>> list(Integer page, Integer size){
        return clientService.list(page, size);
    }
    @GetMapping("/busca-id{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable Integer id) throws NotFoundException {
        return clientService.findById(id);
    }
    @PatchMapping("/editar/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable Integer id, @Valid @RequestBody ClientEditRequest client) throws NotFoundException, BusinessRuleException {
        return clientService.edit(id, client);
    }
    @PostMapping("/criar")
    public ResponseEntity<ClientResponse> create(@Valid @RequestBody ClientCreateRequest client) throws BusinessRuleException {
        return clientService.create(client);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws NotFoundException {
        return clientService.delete(id);
    }
}