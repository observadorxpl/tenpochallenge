package com.tempo.challenge.tenpochallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableCaching
@EnableKafka
public class TenpochallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenpochallengeApplication.class, args);
	}

}
