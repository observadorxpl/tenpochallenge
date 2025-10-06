package com.tempo.challenge.tenpochallenge.client;

import com.tempo.challenge.tenpochallenge.exception.ClientException;
import com.tempo.challenge.tenpochallenge.model.thidparty.GetIVAResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Slf4j
public class IVAClient {
    private final RestTemplate restTemplate;
    @Value("${app.client.iva.host}")
    private String url;

    @Cacheable(value = "ivaCache", key = "'iva'")
    public BigDecimal getIva() {
        try {
            return restTemplate
                .getForObject(url,
                    GetIVAResponse[].class)[0]
                .getValue();
        } catch (HttpClientErrorException httpClientErrorException) {
            throw new ClientException(httpClientErrorException.getStatusCode().value(), url);
        } catch (Exception exception) {
            throw new ClientException(500, url);
        }
    }
}
