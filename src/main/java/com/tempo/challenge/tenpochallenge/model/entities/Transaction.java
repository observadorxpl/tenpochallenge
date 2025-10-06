package com.tempo.challenge.tenpochallenge.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String method;
    private String url;
    private String params;
    private String request;
    private String response;
    private Integer statusCode;
    private LocalDateTime dateTime;
}
