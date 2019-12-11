package br.com.reneg.oslc.controller;

import br.com.reneg.oslc.facade.OslcFacade;
import br.com.reneg.oslc.model.OlscResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/oslc")
@Slf4j
public class OslcController {

    @Autowired
    private OslcFacade oslcFacade;

    @GetMapping("/{cnpj}")
    @ResponseStatus(HttpStatus.CREATED)
    public OlscResponse send(@PathVariable("cnpj") String cpfCnpj) throws Exception {
        return oslcFacade.processaSimulacao(cpfCnpj);
    }
}
