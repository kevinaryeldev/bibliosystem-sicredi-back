package br.com.kevinarteldev.bibliosystem.controller;


import br.com.kevinarteldev.bibliosystem.dto.ClientDTO;
import br.com.kevinarteldev.bibliosystem.dto.PageDTO;
import br.com.kevinarteldev.bibliosystem.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController{
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<PageDTO<ClientDTO>> list(Integer page, Integer size){
        return new ResponseEntity<>(clientService.list(page,size), HttpStatus.OK);
    }
}