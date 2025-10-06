package com.tempo.challenge.tenpochallenge.business;

import com.tempo.challenge.tenpochallenge.client.IVAClient;
import com.tempo.challenge.tenpochallenge.model.dto.GetAmount;
import com.tempo.challenge.tenpochallenge.model.dto.GetAmountResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@AllArgsConstructor
public class AmountServiceImpl implements AmountService {
    private final IVAClient ivaClient;

    @Override
    public GetAmountResponse getAmount(GetAmount getAmount) {
        var IVA = ivaClient.getIva();
        var amount = getAmount.getNum1()
            .add(getAmount.getNum2())
            .multiply(BigDecimal.valueOf(1).add(IVA));
        return GetAmountResponse.builder().amount(amount).build();
    }
}
