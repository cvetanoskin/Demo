package com.example.demo.Exercises.service;

import com.example.demo.Exercises.domain.Product;
import com.example.demo.Exercises.domain.VendingMachine;
import com.example.demo.Exercises.repository.ProductRepository;
import com.example.demo.Exercises.repository.VendingMachineRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {

    private static final List<Integer> ACCEPTED_COINS = Arrays.asList(1, 5, 10, 25, 50);
    private static final List<Integer> ACCEPTED_NOTES = Arrays.asList(1, 2);

    private VendingMachineRepository vendingMachineRepository;
    private ProductRepository productRepository;

    public VendingMachineServiceImpl(VendingMachineRepository vendingMachineRepository, ProductRepository productRepository) {
        this.vendingMachineRepository = vendingMachineRepository;
        this.productRepository = productRepository;
    }

    @Override
    public String insertAmount(int amount, boolean areCents) {

        boolean isValidAmountInput = areCents ? ACCEPTED_COINS.contains(amount) : ACCEPTED_NOTES.contains(amount);
        if (!isValidAmountInput) {
            throw new NumberFormatException("Invalid amount inserted");
        }

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setAmountInserted(50);
        vendingMachine.setChangeReturned(0);
        vendingMachineRepository.save(vendingMachine);

        Product product = new Product();
        product.setName("first product");
        product.setCode("FIRST_PRODUCT");
        product.setNumber(1);
        product.setVendingMachine(vendingMachine);

        Product product2 = new Product();
        product2.setName("second product");
        product2.setCode("SECOND_PRODUCT");
        product2.setNumber(2);
        product2.setVendingMachine(vendingMachine);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        vendingMachine.setProducts(Arrays.asList(product, product2));

        productRepository.saveAll(products);

        return "Inserted amount: " + amount + " " + (areCents ? "cent" : "dollar") + (amount > 1 ? "s": "");
    }
}
