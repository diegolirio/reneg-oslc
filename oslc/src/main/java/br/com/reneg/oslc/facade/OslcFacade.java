package br.com.reneg.oslc.facade;

import br.com.reneg.oslc.model.OlscResponse;
import br.com.reneg.oslc.processor.interfaces.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Component
@EnableBinding({Source.class})
public class OslcFacade {

    @Autowired
    Source source;

    public OlscResponse processaSimulacao(String cpfCnpj) {
        MessageChannel messageChannel = source.sampleSource();
        messageChannel.send(MessageBuilder.withPayload(cpfCnpj)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
        return null;
    }
}
