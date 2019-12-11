package br.com.reneg.oslc.controller;

import br.com.reneg.oslc.facade.OslcFacade;
import br.com.reneg.oslc.model.OlscResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/oslc")
@Slf4j
public class OslcController {

    @Autowired
    private OslcFacade oslcFacade;

    @GetMapping("/{cnpj}")
    @ResponseStatus(HttpStatus.CREATED)
    public RequestEntity<OlscResponse> send(@PathVariable("cnpj") String cpfCnpj) {
        oslcFacade.processaSimulacao(cpfCnpj);
        return null;

    }

    @GetMapping("/processa/{cnpj}")
    @ResponseStatus(HttpStatus.CREATED)
    public RequestEntity<OlscResponse> sendProcessor(@PathVariable("cnpj") String cpfCnpj) {
        oslcFacade.processa(cpfCnpj);
        return null;

    }


}
