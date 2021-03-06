package com.example.demo.Exercises.service;

import com.example.demo.Exercises.domain.Product;
import com.example.demo.Exercises.domain.VendingMachineTransaction;
import com.example.demo.Exercises.repository.ProductRepository;
import com.example.demo.Exercises.repository.VendingMachineTransactionRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VendingMachineTransactionServiceImpl implements VendingMachineTransactionService {

    private static final List<Integer> ACCEPTED_COINS = Arrays.asList(1, 5, 10, 25, 50);
    private static final List<Integer> ACCEPTED_NOTES = Arrays.asList(1, 2);
    private static final int TO_CENTS = 100;

    private final VendingMachineTransactionRepository vendingMachineTransactionRepository;
    private final ProductRepository productRepository;

    public VendingMachineTransactionServiceImpl(VendingMachineTransactionRepository vendingMachineTransactionRepository, ProductRepository productRepository) {
        this.vendingMachineTransactionRepository = vendingMachineTransactionRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Long insertAmount(int amount, boolean areCents) {

        boolean isValidAmountInput = areCents ? ACCEPTED_COINS.contains(amount) : ACCEPTED_NOTES.contains(amount) && amount > 0;
        if (!isValidAmountInput) {
            throw new NumberFormatException("Invalid amount inserted");
        }

        VendingMachineTransaction vendingMachineTransaction = new VendingMachineTransaction();
        vendingMachineTransaction.setAmountInserted(areCents ? amount : amount * TO_CENTS);
        vendingMachineTransactionRepository.save(vendingMachineTransaction);

        return vendingMachineTransaction.getId();
    }

    @Override
    public String buyProduct(Long transactionId, int productNumber) {
        VendingMachineTransaction vendingMachineTransaction = vendingMachineTransactionRepository
                .findById(transactionId)
                .orElseThrow(ResourceNotFoundException::new);

        Product product = productRepository
                .findByNumber(productNumber)
                .orElseThrow(ResourceNotFoundException::new);

        if (vendingMachineTransaction.getAmountInserted() < product.getPrice()) {
            throw new IllegalArgumentException("Amount inserted is too low. If you wish to proceed, please insert more money");
        }

        vendingMachineTransaction.setChangeReturned(vendingMachineTransaction.getAmountInserted() - product.getPrice());
        //todo: Implement Dtos and mappers for Product and VendingMachineTransaction

        return "Product returned: " + product.getName() + ". Change returned: " + vendingMachineTransaction.getChangeReturned();
    }
}
