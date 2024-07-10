package com.example.spring_testing_demo.controller;

import com.example.spring_testing_demo.domain.Transaction;
import com.example.spring_testing_demo.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionsController {
    private final TransactionsService transactionsService;

    @GetMapping()
    public List<Transaction> getTransactions() {
        return transactionsService.getAllTransactions();
    }

//    @PostMapping()

}
