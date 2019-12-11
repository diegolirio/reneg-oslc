package br.com.reneg.oslc.processor;

import br.com.reneg.oslc.processor.interfaces.Sink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(Sink.class)
public class SinkImpl {

    @StreamListener(Sink.SAMPLE)
    public void handle(String cpfCnpj) {
        System.out.println("Received SINK: " + cpfCnpj);
    }
}
