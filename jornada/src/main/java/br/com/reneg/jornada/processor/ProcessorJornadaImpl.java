package br.com.reneg.jornada.processor;


import br.com.reneg.jornada.model.OlscResponse;
import br.com.reneg.jornada.processor.interfaces.ProcessorJornada;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding({ProcessorJornada.class})
public class ProcessorJornadaImpl {

    @StreamListener(ProcessorJornada.SAMPLE)
    @SendTo(ProcessorJornada.OUTPUT)
    public OlscResponse process(String cpfCnpj) {
        OlscResponse olscResponse = new OlscResponse();
        olscResponse.setCpfCnpj(cpfCnpj);
        olscResponse.setNumeroJornada(1L);
        System.out.printf("cpfCnpj= %s e  olscResponse=%s", cpfCnpj, olscResponse);
        return olscResponse;
    }
}