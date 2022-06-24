package com.example.demo.Exercises.repository;

import com.example.demo.Exercises.domain.VendingMachine;
import org.springframework.data.repository.CrudRepository;

public interface VendingMachineRepository extends CrudRepository<VendingMachine, Long> {
}
