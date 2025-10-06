package com.tempo.challenge.tenpochallenge.business;

import com.tempo.challenge.tenpochallenge.model.dto.GetAmount;
import com.tempo.challenge.tenpochallenge.model.dto.GetAmountResponse;

public interface AmountService {
    GetAmountResponse getAmount(GetAmount getAmount);
}
