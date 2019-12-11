package br.com.reneg.oslc.facade;

import br.com.reneg.oslc.model.OlscResponse;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Component;

@Component
public class OslcFacade {

    @Autowired
    ReplyingKafkaTemplate<String, OlscResponse,OlscResponse> kafkaTemplate;

    @Value("${kafka.topic.request-topic}")
    String requestTopic;

    @Value("${kafka.topic.requestreply-topic}")
    String requestReplyTopic;

    public OlscResponse processaSimulacao(String cpfCnpj) throws Exception {
        OlscResponse olscResponse = new OlscResponse();
        olscResponse.setCpfCnpj(cpfCnpj);
        ProducerRecord<String, OlscResponse> record = new ProducerRecord<>(requestTopic, olscResponse);
        record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, requestReplyTopic.getBytes()));
        final RequestReplyFuture<String, OlscResponse, OlscResponse> sendAndReceive = kafkaTemplate.sendAndReceive(record);
        sendAndReceive.getSendFuture().get();
        ConsumerRecord<String, OlscResponse> consumerRecord = sendAndReceive.get();
        return consumerRecord.value();
    }
}
