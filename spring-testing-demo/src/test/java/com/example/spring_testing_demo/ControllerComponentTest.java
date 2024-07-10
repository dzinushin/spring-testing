package com.example.spring_testing_demo;

import com.example.spring_testing_demo.controller.TransactionsController;
import com.example.spring_testing_demo.domain.Transaction;
import com.example.spring_testing_demo.service.TransactionsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringJUnitConfig(TransactionsController.class)
public class ControllerComponentTest {

    @Autowired
    TransactionsController transactionsController;

    @MockBean
    TransactionsService transactionsService;

    @Test
    void test_controller() {
        // given
        List<Transaction> transactionList = List.of(mock(Transaction.class),mock(Transaction.class));
        when(transactionsService.getAllTransactions()).thenReturn(transactionList);

        // when
        List<Transaction> transactions = transactionsController.getTransactions();

        // then
        assertThat(transactions).hasSize(2);
        assertThat(transactions).isEqualTo(transactionList);

        verify(transactionsService).getAllTransactions();
        verifyNoMoreInteractions(transactionsService);
    }
}
