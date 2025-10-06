package com.tempo.challenge.tenpochallenge.web;

import com.tempo.challenge.tenpochallenge.business.AmountService;
import com.tempo.challenge.tenpochallenge.model.dto.GetAmount;
import com.tempo.challenge.tenpochallenge.model.dto.GetAmountResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amounts")
@RequiredArgsConstructor
public class AmountController {
    private final AmountService amountService;

    @GetMapping
    public ResponseEntity<GetAmountResponse> getAmount(@Valid GetAmount getAmount){
        return ResponseEntity.ok(amountService.getAmount(getAmount));
    }
}
