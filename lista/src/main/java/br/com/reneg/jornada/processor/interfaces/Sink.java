package br.com.reneg.oslc.processor.interfaces;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {

    String SAMPLE = "sinkEnvio";

    @Input(SAMPLE)
    SubscribableChannel sampleSink();


}