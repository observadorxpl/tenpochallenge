package com.tempo.challenge.tenpochallenge.business;

import com.tempo.challenge.tenpochallenge.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Mock
    private TransactionRepository transactionRepository;


    @Test
    void shouldReturnTransactionEntities() {
        when(transactionRepository.findAll(any(Pageable.class)))
            .thenReturn(new PageTransactionMock());

        var transactionPage = transactionService.getTransactionEntities(Pageable.unpaged());
        assertEquals(transactionPage.getTotalElements(), 2);
    }

}
