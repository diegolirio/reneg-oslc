package br.com.reneg.jornada.processor.interfaces;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProcessorJornada {

    String SAMPLE = "jornada";

    @Input(SAMPLE)
    SubscribableChannel sampleSink();

    String OUTPUT = "lista";

    @Output("lista")
    MessageChannel output();


}