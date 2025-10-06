package com.tempo.challenge.tenpochallenge.exception;

import lombok.Getter;

@Getter
public class ClientException extends RuntimeException {
    private final String code;
    private final Integer httpStatusCode;
    private final String message;

    public ClientException(Integer httpStatusCode, String url) {
        this.code = "EX001";
        this.httpStatusCode = httpStatusCode;
        this.message = String.format("Exception client: %s", url);
    }
}
