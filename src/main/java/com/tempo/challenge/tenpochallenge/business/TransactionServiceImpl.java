package com.tempo.challenge.tenpochallenge.business;

import com.tempo.challenge.tenpochallenge.kafka.producer.TransactionProducer;
import com.tempo.challenge.tenpochallenge.model.dto.GetTransactionHistoryResponse;
import com.tempo.challenge.tenpochallenge.model.entities.Transaction;
import com.tempo.challenge.tenpochallenge.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionProducer messageProducer;

    @Override
    public void processTransaction(ClientHttpResponse clientHttpResponse, HttpRequest request, byte[] body) throws IOException {
        var transaction = buildTransaction(clientHttpResponse, request, body);
        messageProducer.sendMessage(transaction);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Page<Transaction> getTransactionEntities(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public Page<GetTransactionHistoryResponse> getTransactionDTOs(Pageable pageable) {
        return getTransactionEntities(pageable).map(this::buildGetTransactionHistoryResponse);
    }


    private GetTransactionHistoryResponse buildGetTransactionHistoryResponse(Transaction transaction) {
        return GetTransactionHistoryResponse.builder()
            .id(transaction.getId())
            .method(transaction.getMethod())
            .url(transaction.getUrl())
            .params(transaction.getParams())
            .request(transaction.getRequest())
            .response(transaction.getResponse())
            .statusCode(transaction.getStatusCode())
            .dateTime(transaction.getDateTime())
            .build();
    }

    private Transaction buildTransaction(ClientHttpResponse clientHttpResponse,
                                         HttpRequest request,
                                         byte[] body) throws IOException {

        return Transaction.builder()
            .method(request.getMethod().name())
            .url(request.getURI().toString())
            .params(request.getURI().getQuery())
            .request(new String(body, UTF_8))
            .response(getResponse(clientHttpResponse))
            .statusCode(clientHttpResponse.getStatusCode().value())
            .dateTime(LocalDateTime.now())
            .build();
    }

    private String getResponse(ClientHttpResponse clientHttpResponse) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientHttpResponse.getBody(), UTF_8));
        String line = bufferedReader.readLine();
        while (line != null) {
            inputStringBuilder.append(line);
            line = bufferedReader.readLine();
        }
        return inputStringBuilder.toString();
    }
}
