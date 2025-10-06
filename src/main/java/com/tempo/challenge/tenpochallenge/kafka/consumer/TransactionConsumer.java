package com.tempo.challenge.tenpochallenge.kafka.consumer;

import com.tempo.challenge.tenpochallenge.business.TransactionService;
import com.tempo.challenge.tenpochallenge.model.entities.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionConsumer {
    private final TransactionService transactionService;

    @KafkaListener(topics = "transaction-topic", groupId = "transaction-group")
    public void consume(Transaction transaction) throws InterruptedException {
        log.info("Message received: " + transaction);
        Thread.sleep(Duration.ofSeconds(5));
        transactionService.saveTransaction(transaction);
        log.info("Message processed: " + transaction);
    }
}
