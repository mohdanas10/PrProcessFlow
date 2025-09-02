package com.PrProcessFlow.PrProcessFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrProcessFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrProcessFlowApplication.class, args);
//		System.out.println(">>> JwtAuthFilter triggered for request: " + request.getRequestURI());

		System.out.println("Hi this is my pr process flow application");
	}

}
