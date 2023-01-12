package br.com.kevinarteldev.bibliosystem.controller;


import br.com.kevinarteldev.bibliosystem.dto.ClientCreateDTO;
import br.com.kevinarteldev.bibliosystem.dto.ClientDTO;
import br.com.kevinarteldev.bibliosystem.dto.PageDTO;
import br.com.kevinarteldev.bibliosystem.service.ClientService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
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
    public ResponseEntity<PageDTO<ClientDTO>> list(Integer page, Integer size){
        return new ResponseEntity<>(clientService.list(page,size), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Integer id){
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @Valid @RequestBody ClientCreateDTO clientCreateDTO){
        return new ResponseEntity<>(clientService.update(id, clientCreateDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientCreateDTO client){
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}