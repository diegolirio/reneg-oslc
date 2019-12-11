package br.com.reneg.oslc.processor.interfaces;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Processor {

    String SAMPLE = "sinkEnvio";

    @Input(SAMPLE)
    SubscribableChannel sampleSink();

    String OUTPUT = "processor";

    @Output("processor")
    MessageChannel output();


}