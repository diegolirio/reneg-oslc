package br.com.reneg.oslc.facade;

import br.com.reneg.oslc.model.OlscResponse;
import br.com.reneg.oslc.processor.interfaces.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import javax.annotation.processing.Processor;

@Component
@EnableBinding({Source.class, Processor.class})
public class OslcFacade {

    @Autowired
    Source source;

    @Autowired
    Processor processor;


    public OlscResponse processaSimulacao(String cpfCnpj) {
        MessageChannel messageChannel = source.sampleSource();
        boolean send = messageChannel.send(MessageBuilder.withPayload(cpfCnpj)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());

        return null;
    }

    public OlscResponse processa(String cpfCnpj) {
//        processor.init(cpfCnpj);
//
//        Object payload = messageCollector.forChannel(pipe.output())
//                .poll()
//                .getPayload();
        return null;
    }

}
