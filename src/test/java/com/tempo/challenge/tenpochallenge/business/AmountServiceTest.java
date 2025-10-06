package com.tempo.challenge.tenpochallenge.business;

import com.tempo.challenge.tenpochallenge.client.IVAClient;
import com.tempo.challenge.tenpochallenge.model.dto.GetAmount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AmountServiceTest {

    @InjectMocks
    private AmountServiceImpl amountService;
    @Mock
    private IVAClient ivaClient;


    @Test
    void shouldCalculate() {
        GetAmount getAmount = GetAmount.builder()
            .num1(BigDecimal.TEN)
            .num2(BigDecimal.TWO)
            .build();

        when(ivaClient.getIva()).thenReturn(BigDecimal.valueOf(0.19));
        var amountResponse = amountService.getAmount(getAmount);
        assertEquals(BigDecimal.valueOf(14.28), amountResponse.getAmount());
    }
}
