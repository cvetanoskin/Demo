package com.example.demo.Exercises.service;

public interface VendingMachineTransactionService {
    Long insertAmount(int amount, boolean areCents);
}
