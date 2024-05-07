package com.example.bankapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="account_holders_name")
    private String accountHolderName;
    @Column(name = "account_balance")
    private double balance;


}
