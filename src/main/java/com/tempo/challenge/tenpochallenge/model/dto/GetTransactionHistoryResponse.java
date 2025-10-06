package com.tempo.challenge.tenpochallenge.model.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetTransactionHistoryResponse {
    private UUID id;
    private String method;
    private String url;
    private String params;
    private String request;
    private String response;
    private Integer statusCode;
    private LocalDateTime dateTime;
}
