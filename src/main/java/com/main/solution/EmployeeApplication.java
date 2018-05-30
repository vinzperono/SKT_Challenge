package com.main.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * Main class for Spring boot
 */
@Slf4j
@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		
		//Service graceful shutdown 
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Exiting application...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            log.info("Shutting down...");
        }));
		
		SpringApplication.run(EmployeeApplication.class, args);
	}
}
