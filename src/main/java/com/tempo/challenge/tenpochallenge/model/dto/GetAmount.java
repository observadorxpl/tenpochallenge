package com.tempo.challenge.tenpochallenge.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAmount {
    @NotNull(message = "El valor num1 no debe ser nulo")
    private BigDecimal num1;
    @NotNull(message = "El valor num2 no debe ser nulo")
    private BigDecimal num2;
}
