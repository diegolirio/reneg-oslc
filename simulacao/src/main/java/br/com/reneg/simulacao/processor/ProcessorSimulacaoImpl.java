package br.com.reneg.simulacao.processor;


import br.com.reneg.simulacao.model.OlscResponse;
import br.com.reneg.simulacao.processor.interfaces.ProcessorSimulacao;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding({ProcessorSimulacao.class})
public class ProcessorSimulacaoImpl {

    @StreamListener(ProcessorSimulacao.SAMPLE)
    @SendTo(ProcessorSimulacao.OUTPUT)
    public OlscResponse process(OlscResponse olscResponse) {
        olscResponse.setValor(113.44);
        System.out.printf("Simulacao  olscResponse=%s\n", olscResponse);
        return olscResponse;
    }
}