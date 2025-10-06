package com.tempo.challenge.tenpochallenge.model.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TenpoExceptionResponse {
    private String code;
    private String message;
    private String detail;
}
