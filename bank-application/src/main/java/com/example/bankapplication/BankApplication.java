package com.example.bankapplication;

import com.example.bankapplication.model.Account;
import com.example.bankapplication.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {
	@Autowired
	private AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account account = new Account();
		account.setAccountHolderName("Justine");
		account.setBalance(000.00);
		accountRepository.save(account);

		Account account1 = new Account();
		account1.setAccountHolderName("Tina");
		account1.setBalance(000.00);
		accountRepository.save(account);

	}
}
