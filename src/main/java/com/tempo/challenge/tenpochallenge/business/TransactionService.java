package com.tempo.challenge.tenpochallenge.business;

import com.tempo.challenge.tenpochallenge.model.dto.GetTransactionHistoryResponse;
import com.tempo.challenge.tenpochallenge.model.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public interface TransactionService {
    void processTransaction(ClientHttpResponse clientHttpResponse,
                            HttpRequest request,
                            byte[] body) throws IOException;
    Transaction saveTransaction(Transaction transaction);

    Page<Transaction> getTransactionEntities(Pageable pageable);
    Page<GetTransactionHistoryResponse> getTransactionDTOs(Pageable pageable);
}
