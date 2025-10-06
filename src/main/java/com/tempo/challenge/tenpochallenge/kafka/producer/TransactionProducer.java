package com.tempo.challenge.tenpochallenge.kafka.producer;

import com.tempo.challenge.tenpochallenge.model.entities.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionProducer {
    private final KafkaTemplate<String, Transaction> kafkaTemplate;
    @Value("${app.kafka.topic}")
    private String topic;

    public void sendMessage(Transaction transaction) {
        log.info("Sending message: {} ", transaction.toString());
        kafkaTemplate.send(topic, transaction);
    }
}
