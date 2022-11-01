package com.ttinder.ttinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableJpaAuditing
public class TtinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtinderApplication.class, args);
	}


}
