package com.eteration.simplebanking.model;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.UUID;

// This class is a place holder you can change the complete implementation

@Entity
@DiscriminatorValue("WithdrawalTransaction")
public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction( double amount) {
        super(amount);
    }

    public WithdrawalTransaction() {

    }
}


