package com.springbootproject.bank;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for running the Spring Boot application.
 */
@SpringBootApplication
@Slf4j
public class BankApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	/**
	 * Override the run() method from the CommandLineRunner interface
	 * so that we can log that the app has started.
	 *
	 * @param args
	 */
	@Override
	public void run(String ... args) {
		log.info("BankApplication has started.");
	}

}
