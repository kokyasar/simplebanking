package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation




import com.eteration.simplebanking.services.AccountService;
import com.eteration.simplebanking.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
public class Account {


    @Column
    private String accountOwner;
    @Id
    @Column
    private String accountNumber;
    @Column
    private double balance;

    @Column
    private LocalDateTime createDate;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
    }



    public Account(String owner, String number) {
        this.accountOwner = owner;
        this.accountNumber = number;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) throws InsufficientBalanceException {
        balance = balance + amount ;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Not enough balance.");
        }
        balance = balance - amount ;
    }

    public void post(Transaction transaction) throws InsufficientBalanceException {
       if (transaction instanceof DepositTransaction){
           deposit(transaction.getAmount());

       }else if (transaction instanceof WithdrawalTransaction) {
           withdraw(transaction.getAmount());
       }
        transactions.add(transaction);
        transaction.setAccount(this);
    }
    public void post(BillPaymentTransaction billPaymentTransaction) throws InsufficientBalanceException{
        withdraw(billPaymentTransaction.getPayee());
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}

