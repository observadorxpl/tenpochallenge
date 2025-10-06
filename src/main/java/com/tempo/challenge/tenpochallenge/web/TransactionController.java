package com.tempo.challenge.tenpochallenge.web;

import com.tempo.challenge.tenpochallenge.business.TransactionService;
import com.tempo.challenge.tenpochallenge.model.dto.GetTransactionHistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<Page<GetTransactionHistoryResponse>> getTransactions(Pageable pageable){
         return ResponseEntity.ok(transactionService.getTransactionDTOs(pageable));
    }
}
