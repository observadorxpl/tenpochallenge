package com.tempo.challenge.tenpochallenge.model.thidparty;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetIVAResponse {
    private BigDecimal value;
}
