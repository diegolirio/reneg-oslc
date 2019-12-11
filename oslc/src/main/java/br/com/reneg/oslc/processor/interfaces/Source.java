package br.com.reneg.oslc.processor.interfaces;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {
    String SAMPLE = "jornada";

    @Output(SAMPLE)
    MessageChannel sampleSource();
}
