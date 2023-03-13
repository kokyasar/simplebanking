package com.eteration.simplebanking.model;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

// This class is a place holder you can change the complete implementation

@Entity
@DiscriminatorValue("DepositTransaction")
public class DepositTransaction extends Transaction  {

    public DepositTransaction(double amount) throws InsufficientBalanceException {
        super(amount);
    }

    public DepositTransaction() {

    }
}
