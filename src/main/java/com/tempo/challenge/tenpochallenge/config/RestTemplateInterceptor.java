package com.tempo.challenge.tenpochallenge.config;

import com.tempo.challenge.tenpochallenge.business.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    private final TransactionService transactionService;

    @Override
    public ClientHttpResponse intercept(HttpRequest request,
                                        byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse clientHttpResponse = execution.execute(request, body);
        ClientHttpResponse newCopiedResponse = new BufferingClientHttpResponseWrapper(clientHttpResponse);
        transactionService.processTransaction(newCopiedResponse, request, body);
        return newCopiedResponse;
    }
}
