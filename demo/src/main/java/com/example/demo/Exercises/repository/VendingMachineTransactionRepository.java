package com.example.demo.Exercises.repository;

import com.example.demo.Exercises.domain.VendingMachineTransaction;
import org.springframework.data.repository.CrudRepository;

public interface VendingMachineTransactionRepository extends CrudRepository<VendingMachineTransaction, Long> {
}
