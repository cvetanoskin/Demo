package com.example.demo.Exercises.service;

import com.example.demo.Exercises.repository.VendingMachineRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {

    private static final List<Integer> ACCEPTED_COINS = Arrays.asList(1, 5, 10, 25, 50);
    private static final List<Integer> ACCEPTED_NOTES = Arrays.asList(1, 2);

    private VendingMachineRepository vendingMachineRepository;

    public VendingMachineServiceImpl(VendingMachineRepository vendingMachineRepository) {
        this.vendingMachineRepository = vendingMachineRepository;
    }

    @Override
    public String insertAmount(int amount, boolean areCents) {

        boolean isValidAmountInput = areCents ? ACCEPTED_COINS.contains(amount) : ACCEPTED_NOTES.contains(amount);
        if (!isValidAmountInput) {
            throw new NumberFormatException("Invalid amount inserted");
        }


        return "Inserted amount: " + amount + " " + (areCents ? "cent" : "dollar") + (amount > 1 ? "s": "");
    }
}
