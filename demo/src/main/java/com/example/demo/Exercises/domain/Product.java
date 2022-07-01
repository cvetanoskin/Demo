package com.example.demo.Exercises.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private Integer number;

    private Integer price;
}
