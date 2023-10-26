package me.dio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MicroServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApp.class, args);
	}

}
