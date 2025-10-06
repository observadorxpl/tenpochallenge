package com.tempo.challenge.tenpochallenge.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class GetAmountResponse {
    private BigDecimal amount;
}
