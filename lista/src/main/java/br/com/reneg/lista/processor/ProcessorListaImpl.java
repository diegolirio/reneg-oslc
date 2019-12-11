package br.com.reneg.lista.processor;


import br.com.reneg.lista.model.OlscResponse;
import br.com.reneg.lista.processor.interfaces.ProcessorLista;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import java.time.LocalDate;

@SpringBootApplication
@EnableBinding({ProcessorLista.class})
public class ProcessorListaImpl {

    @StreamListener(ProcessorLista.SAMPLE)
    @SendTo(ProcessorLista.OUTPUT)
    public OlscResponse process(OlscResponse olscResponse) {
        olscResponse.setNumeroJornada(1L);
        olscResponse.setDataJornada(LocalDate.now());
        System.out.printf("LC1 olscResponse=%s\n", olscResponse);
        return olscResponse;
    }
}