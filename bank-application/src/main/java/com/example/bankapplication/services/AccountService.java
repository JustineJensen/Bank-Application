package com.example.bankapplication.services;

import com.example.bankapplication.model.Account;
import com.example.bankapplication.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public Account createAccount(Account account){
        return  accountRepository.save(account);
    }
    public Optional<Account> getAccount(Long id){
      return  accountRepository.findById(id);
    }
    public Account deposit(long id, double amount){
        Account account = getAccount(id).orElseThrow(() -> new NoSuchElementException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }
    public Account withdraw(Long id, long amount){
        Account account = getAccount(id).orElseThrow(()-> new NoSuchElementException("Account not fount"));
        if(account.getBalance()<amount){
            throw  new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance()-amount);
        return  accountRepository.save(account);
    }
}
