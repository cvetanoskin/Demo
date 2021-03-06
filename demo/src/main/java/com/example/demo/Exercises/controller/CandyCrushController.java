package com.example.demo.Exercises.controller;

import com.example.demo.Exercises.service.CandyCrushService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CandyCrushController {

    private final CandyCrushService candyCrushService;

    public CandyCrushController(CandyCrushService candyCrushService) {
        this.candyCrushService = candyCrushService;
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome";
    }

    @PostMapping("/candycrush")
    @ResponseBody
    public String modifyCandyCrushBlock(@RequestBody List<String> candyCrushList) {
        return candyCrushService.createCandyCrushString(candyCrushList);
    }
}
