package com.example.spring_testing_demo.service;

import com.example.spring_testing_demo.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionsService {
    public List<Transaction> getAllTransactions() {
        return Collections.emptyList();
    }
}
