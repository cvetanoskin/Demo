package com.example.demo.Exercises.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class VendingMachine {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Integer moneyInserted;

    private Integer change;

    @OneToMany
    private List<Product> products;
}
