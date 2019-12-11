package br.com.reneg.oslc.processor;


import br.com.reneg.oslc.model.OlscResponse;
import br.com.reneg.oslc.processor.interfaces.ProcessorOslc;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding({ProcessorOslc.class})
public class ProcessorOslcImpl {

    @StreamListener(ProcessorOslc.SAMPLE)
    @SendTo(ProcessorOslc.OUTPUT)
    public OlscResponse process(OlscResponse olscResponse) {
        System.out.println("Jornada Recebe e Enviar jo: " + olscResponse);
        return olscResponse;
    }
}