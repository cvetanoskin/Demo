package com.example.demo.Exercises.service;

import com.example.demo.Exercises.domain.Product;
import com.example.demo.Exercises.domain.VendingMachineTransaction;
import com.example.demo.Exercises.repository.ProductRepository;
import com.example.demo.Exercises.repository.VendingMachineTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VendingMachineTransactionServiceImpl implements VendingMachineTransactionService {

    private static final List<Integer> ACCEPTED_COINS = Arrays.asList(1, 5, 10, 25, 50);
    private static final List<Integer> ACCEPTED_NOTES = Arrays.asList(1, 2);

    private VendingMachineTransactionRepository vendingMachineTransactionRepository;
    private ProductRepository productRepository;

    public VendingMachineTransactionServiceImpl(VendingMachineTransactionRepository vendingMachineTransactionRepository, ProductRepository productRepository) {
        this.vendingMachineTransactionRepository = vendingMachineTransactionRepository;
        this.productRepository = productRepository;
    }

    @Override
    public String insertAmount(int amount, boolean areCents) {

        boolean isValidAmountInput = areCents ? ACCEPTED_COINS.contains(amount) : ACCEPTED_NOTES.contains(amount);
        if (!isValidAmountInput) {
            throw new NumberFormatException("Invalid amount inserted");
        }

        VendingMachineTransaction vendingMachineTransaction = new VendingMachineTransaction();
        vendingMachineTransaction.setAmountInserted(50);
        vendingMachineTransaction.setChangeReturned(0);
        vendingMachineTransactionRepository.save(vendingMachineTransaction);

        Product product = new Product();
        product.setName("first product");
        product.setCode("FIRST_PRODUCT");
        product.setNumber(1);
        product.setVendingMachineTransaction(vendingMachineTransaction);

        Product product2 = new Product();
        product2.setName("second product");
        product2.setCode("SECOND_PRODUCT");
        product2.setNumber(2);
        product2.setVendingMachineTransaction(vendingMachineTransaction);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        vendingMachineTransaction.setProducts(Arrays.asList(product, product2));

        productRepository.saveAll(products);

        return "Inserted amount: " + amount + " " + (areCents ? "cent" : "dollar") + (amount > 1 ? "s": "");
    }
}
