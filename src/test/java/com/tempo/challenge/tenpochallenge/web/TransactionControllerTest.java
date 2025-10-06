package com.tempo.challenge.tenpochallenge.web;

import com.tempo.challenge.tenpochallenge.business.PageTransactionDTOMock;
import com.tempo.challenge.tenpochallenge.business.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {
    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private TransactionServiceImpl transactionService;

    @Test
    void shouldReturn200(){
        when(transactionService.getTransactionDTOs(any(Pageable.class)))
            .thenReturn(new PageTransactionDTOMock());

        var responseEntity = transactionController.getTransactions(Pageable.unpaged());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(2, responseEntity.getBody().getTotalElements());
        assertEquals(1, responseEntity.getBody().getTotalPages());
    }
}
