package com.example.demo.Exercises.controller;

import com.example.demo.Exercises.service.VendingMachineTransactionService;
import org.springframework.web.bind.annotation.*;


@RestController
public class VendingMachineTransactionController {

    private VendingMachineTransactionService vendingMachineTransactionService;

    public VendingMachineTransactionController(VendingMachineTransactionService vendingMachineTransactionService) {
        this.vendingMachineTransactionService = vendingMachineTransactionService;
    }

    @PostMapping("/insertamount")
    public Long insertAmount(@RequestParam int amount, @RequestParam boolean areCents) {
        return vendingMachineTransactionService.insertAmount(amount, areCents);
    }

    @GetMapping("/buyproduct")
    public String buyProduct(@RequestParam Long transactionId, @RequestParam int productNumber) {
        return vendingMachineTransactionService.buyProduct(transactionId, productNumber);
    }
}
