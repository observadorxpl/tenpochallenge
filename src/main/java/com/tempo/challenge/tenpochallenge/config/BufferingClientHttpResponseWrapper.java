package com.tempo.challenge.tenpochallenge.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferingClientHttpResponseWrapper implements ClientHttpResponse {

    private final ClientHttpResponse response;
    private byte[] body;

    public BufferingClientHttpResponseWrapper(ClientHttpResponse response) {
        this.response = response;
    }

    @Override
    public InputStream getBody() throws IOException {
        if (body == null) {
            body = StreamUtils.copyToByteArray(response.getBody());
        }
        return new ByteArrayInputStream(body);
    }

    @Override
    public HttpStatus getStatusCode() throws IOException {
        return (HttpStatus) this.response.getStatusCode();
    }


    @Override
    public String getStatusText() throws IOException {
        return this.response.getStatusText();
    }

    @Override
    public HttpHeaders getHeaders() {
        return this.response.getHeaders();
    }

    @Override
    public void close() {
        this.response.close();
    }
}
