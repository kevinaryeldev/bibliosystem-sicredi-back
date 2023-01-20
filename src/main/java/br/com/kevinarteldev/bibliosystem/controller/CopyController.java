package br.com.kevinarteldev.bibliosystem.controller;


import br.com.kevinarteldev.bibliosystem.service.CopyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@Slf4j
@RestController
@RequestMapping("/copy")
public class CopyController {

    private final CopyService copyService;

    public CopyController(CopyService copyService) {
        this.copyService = copyService;
    }

}
