package br.com.reneg.simulacao.processor.interfaces;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProcessorSimulacao {

    String SAMPLE = "simulacao";

    @Input(SAMPLE)
    SubscribableChannel sampleSink();

    String OUTPUT = "fimOslc";

    @Output("fimOslc")
    MessageChannel output();


}