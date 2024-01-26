package com.ex.picpaysimplificado.service;

import com.ex.picpaysimplificado.dtos.TransactionDTO;
import com.ex.picpaysimplificado.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private UserServices userServices;
    @Autowired
    private TransactionRepository repository;

    public void createTransaction(TransactionDTO transaction){

    }
}
