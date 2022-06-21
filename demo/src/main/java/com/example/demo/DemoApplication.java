package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

//		System.out.println(candyCrushService.createCandyCrushString(Arrays.asList("A", "B", "C", "C", "C", "B"))); //ABB
//		System.out.println(candyCrush.candyCrushString(Arrays.asList("A","B","B","C","C","C","B","A"))); //AA
//		System.out.println(candyCrush.candyCrushString(Arrays.asList("A","B","C","B","B","A","A","C","C","C","C","A","A","B"))); //ABC
	}

}
