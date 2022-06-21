package com.example.demo.Exercises.services;

import com.example.demo.Exercises.domains.CandyCrush;
import com.example.demo.Exercises.repositories.CandyCrushRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CandyCrushServiceImpl implements CandyCrushService {

    private final CandyCrushRepository candyCrushRepository;

    public CandyCrushServiceImpl(CandyCrushRepository candyCrushRepository) {
        this.candyCrushRepository = candyCrushRepository;
    }

    @Override
    public String createCandyCrushString(List<String> candyCrushList) {
        CandyCrush candyCrush = new CandyCrush();
        candyCrush.setInputSequence(candyCrushList.toString());
        candyCrush.setOutputSequence(candyCrushString(candyCrushList));
        candyCrushRepository.save(candyCrush);
        return StringUtils.isNotEmpty(candyCrush.getOutputSequence()) ? candyCrush.getOutputSequence() : null;
    }

    private String candyCrushString(List<String> inputList) {

        StringBuilder sb = new StringBuilder();
        int countSequence = 1;
        for (int i = 0; i < inputList.size(); i++) {
            if (i < inputList.size() - 1 && Objects.equals(inputList.get(i), inputList.get(i + 1))) {
                countSequence++;
            } else {
                if (countSequence < 3) {
                    for (int j = 0; j < countSequence; j++) {
                        sb.append(inputList.get(i));
                    }
                }
                countSequence = 1;
            }
        }
        List<String> listAfterModification = new ArrayList<>(Arrays.asList(sb.toString().split("")));
        if (inputList.equals(listAfterModification)) {
            return inputList.toString();
        }
        return candyCrushString(listAfterModification);
    }
}
