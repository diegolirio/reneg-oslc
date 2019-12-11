package br.com.reneg.oslc.processor.interfaces;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface Source {
    String SAMPLE = "sample-source";

    @Output(SAMPLE)
    MessageChannel sampleSource();
}
