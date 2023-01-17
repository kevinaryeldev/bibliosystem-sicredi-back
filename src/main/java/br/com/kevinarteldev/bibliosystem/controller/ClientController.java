package br.com.kevinarteldev.bibliosystem.controller;


import br.com.kevinarteldev.bibliosystem.request.ClientCreateRequest;
import br.com.kevinarteldev.bibliosystem.request.ClientEditRequest;
import br.com.kevinarteldev.bibliosystem.response.ClientResponse;
import br.com.kevinarteldev.bibliosystem.response.PageResponse;
import br.com.kevinarteldev.bibliosystem.service.ClientService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController{
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<PageResponse<ClientResponse>> list(Integer page, Integer size){
        return new ResponseEntity<>(clientService.list(page,size), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable Integer id){
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable Integer id, @Valid @RequestBody ClientEditRequest client){
        return new ResponseEntity<>(clientService.edit(id, client), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ClientResponse> create(@Valid @RequestBody ClientCreateRequest client){
        return new ResponseEntity<>(clientService.create(client),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}