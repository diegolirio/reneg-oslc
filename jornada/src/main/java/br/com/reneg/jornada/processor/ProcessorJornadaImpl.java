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
    public OlscResponse process(OlscResponse olscResponse) {
        if (olscResponse.getCpfCnpj().equals("123")){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        olscResponse.setNumeroJornada(1L);
        System.out.printf("Jornada olscResponse=%s\n", olscResponse);
        return olscResponse;
    }
}