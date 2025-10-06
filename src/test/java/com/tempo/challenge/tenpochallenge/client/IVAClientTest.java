package com.tempo.challenge.tenpochallenge.client;

import com.tempo.challenge.tenpochallenge.exception.ClientException;
import com.tempo.challenge.tenpochallenge.model.thidparty.GetIVAResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ExtendWith(MockitoExtension.class)
public class IVAClientTest {
    @InjectMocks
    private IVAClient ivaClient;

    @Mock
    private RestTemplate restTemplate;



    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(ivaClient, "url", "https://example.com/iva");
    }

    @Test
    void shouldReturnIVA() {
        var ivaResponse = new GetIVAResponse(BigDecimal.valueOf(0.19));
        GetIVAResponse[] ivaResponses = {ivaResponse};
        when(restTemplate.getForObject(anyString(), any())).thenReturn(ivaResponses);

        var IVA = ivaClient.getIva();
        assertEquals(BigDecimal.valueOf(0.19), IVA);
    }

    @Test
    void shouldReturnAClientException() {
        when(restTemplate.getForObject(anyString(), any())).thenThrow(new HttpServerErrorException(INTERNAL_SERVER_ERROR));

        assertThrows(ClientException.class, () -> ivaClient.getIva());
    }
}
