package com.example.demo.Exercises.service;

import com.example.demo.Exercises.domain.Product;
import com.example.demo.Exercises.domain.VendingMachine;
import com.example.demo.Exercises.domain.VendingMachineTransaction;
import com.example.demo.Exercises.repository.ProductRepository;
import com.example.demo.Exercises.repository.VendingMachineRepository;
import com.example.demo.Exercises.repository.VendingMachineTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VendingMachineTransactionServiceImpl implements VendingMachineTransactionService {

    private static final List<Integer> ACCEPTED_COINS = Arrays.asList(1, 5, 10, 25, 50);
    private static final List<Integer> ACCEPTED_NOTES = Arrays.asList(1, 2);
    private static final int TO_CENTS = 100;

    private VendingMachineRepository vendingMachineRepository;
    private VendingMachineTransactionRepository vendingMachineTransactionRepository;
    private ProductRepository productRepository;

    public VendingMachineTransactionServiceImpl(VendingMachineRepository vendingMachineRepository, VendingMachineTransactionRepository vendingMachineTransactionRepository, ProductRepository productRepository) {
        this.vendingMachineRepository = vendingMachineRepository;
        this.vendingMachineTransactionRepository = vendingMachineTransactionRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Long insertAmount(int amount, boolean areCents) {

        boolean isValidAmountInput = areCents ? ACCEPTED_COINS.contains(amount) : ACCEPTED_NOTES.contains(amount);
        if (!isValidAmountInput) {
            throw new NumberFormatException("Invalid amount inserted");
        }

        VendingMachineTransaction vendingMachineTransaction = new VendingMachineTransaction();
        vendingMachineTransaction.setAmountInserted(areCents ? amount : amount * TO_CENTS);
        vendingMachineTransactionRepository.save(vendingMachineTransaction);

        return vendingMachineTransaction.getId();
    }
}
