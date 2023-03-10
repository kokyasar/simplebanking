package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Account {

    @Id
    private String accountNumber;
    private String owner;
    private double balance;
    private LocalDate createDate;
    private Long transactionID;

}
