package com.example.demo.Exercises.controller;

import com.example.demo.Exercises.service.VendingMachineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendingMachineController {

    private VendingMachineService vendingMachineService;

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    @PostMapping("/insertamount")
    public String insertAmount(@RequestParam int amount, @RequestParam boolean areCents) {
        return vendingMachineService.insertAmount(amount, areCents);
    }
}
