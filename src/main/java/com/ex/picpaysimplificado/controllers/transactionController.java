package com.ex.picpaysimplificado.controllers;

import com.ex.picpaysimplificado.domain.transaction.Transaction;
import com.ex.picpaysimplificado.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class transactionController {
    @Autowired
    private TransactionService transactionService;

}
