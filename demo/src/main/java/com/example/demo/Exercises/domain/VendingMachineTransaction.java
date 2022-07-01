package com.example.demo.Exercises.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class VendingMachineTransaction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount_inserted")
    private Integer amountInserted;

    @Column(name = "change_returned")
    private Integer changeReturned;

    @OneToMany
    private List<Product> products;

}
