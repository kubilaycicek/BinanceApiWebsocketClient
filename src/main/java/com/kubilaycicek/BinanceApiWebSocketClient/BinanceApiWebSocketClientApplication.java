package com.kubilaycicek.BinanceApiWebSocketClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BinanceApiWebSocketClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BinanceApiWebSocketClientApplication.class, args);
	}

}
