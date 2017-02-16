package net.woniper.data.rest;

import net.woniper.data.rest.web.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataRestApplication.class, args);
	}

	@Autowired
	private AccountRepository accountRepository;

	@Bean
	public CommandLineRunner commandLineRunner() {
		return arg -> {
			for (int i = 0; i < 5; i++) {
				accountRepository.save(new Account("woniper" + i));
			}
		};
	}

}
