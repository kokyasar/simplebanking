package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.AccountService;
import com.eteration.simplebanking.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account/v1")
public class AccountController {
    private final AccountService accountService;

    private final TransactionService transactionService;

    public AccountController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @PostMapping("/saveAccount")
    public ResponseEntity<String>  createAccount (@RequestBody Account account){
            accountService.createAccount(account);
        return ResponseEntity.ok().body("Account saved");
    }
    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        Account account = accountService.findAccount(accountNumber);
        return ResponseEntity.ok().body(account);
    }

    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable("accountNumber") String accountNumber,
                                                    @RequestBody DepositTransaction depositTransaction) throws InsufficientBalanceException {
        Account account= accountService.findAccount(accountNumber);
        account.post(depositTransaction);
        transactionService.saveTransaction(depositTransaction);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setStatus("OK");
        transactionStatus.setApprovalCode(depositTransaction.getApprovalCode());
        return ResponseEntity.ok().body(transactionStatus);
    }
    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable("accountNumber") String accountNumber,
                                                   @RequestBody WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {

        Account account= accountService.findAccount(accountNumber);
        account.post(withdrawalTransaction);
        transactionService.saveTransaction(withdrawalTransaction);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setStatus("OK");
        transactionStatus.setApprovalCode(withdrawalTransaction.getApprovalCode());
        return ResponseEntity.ok().body(transactionStatus);
	}
}