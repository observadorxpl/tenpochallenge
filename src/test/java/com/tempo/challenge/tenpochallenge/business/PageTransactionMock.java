package com.tempo.challenge.tenpochallenge.business;

import com.tempo.challenge.tenpochallenge.model.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public class PageTransactionMock implements Page<Transaction> {
    @Override
    public int getTotalPages() {
        return 1;
    }

    @Override
    public long getTotalElements() {
        return getTransactions().size();
    }

    @Override
    public int getNumber() {
        return getTransactions().size();
    }

    @Override
    public int getSize() {
        return getTransactions().size();
    }

    @Override
    public int getNumberOfElements() {
        return getTransactions().size();
    }

    @Override
    public List<Transaction> getContent() {
        return getTransactions();
    }

    private List<Transaction> getTransactions() {
        var transaction1 = Transaction.builder()
            .id(UUID.randomUUID())
            .method("GET")
            .url("example.com")
            .params("param1=value1")
            .request(null)
            .response( "[{\"value\": 0.19}]")
            .statusCode(200)
            .dateTime(LocalDateTime.now())
            .build();

        var transaction2 = Transaction.builder()
            .id(UUID.randomUUID())
            .method("GET")
            .url("example.com")
            .params("param1=value1")
            .request(null)
            .response( "[{\"value\": 0.21}]")
            .statusCode(200)
            .dateTime(LocalDateTime.now())
            .build();

        return List.of(transaction1, transaction2);
    }

    @Override
    public boolean hasContent() {
        return false;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public boolean isFirst() {
        return false;
    }

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Pageable nextPageable() {
        return null;
    }

    @Override
    public Pageable previousPageable() {
        return null;
    }

    @Override
    public <U> Page<U> map(Function<? super Transaction, ? extends U> converter) {
        return null;
    }

    @Override
    public Iterator<Transaction> iterator() {
        return null;
    }
}
