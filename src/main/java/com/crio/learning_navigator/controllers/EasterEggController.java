package com.crio.learning_navigator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hidden-feature")
public class EasterEggController {

    @GetMapping("/{number}")
    public String getNumberFact(@PathVariable("number") int number) {
        String apiUrl = "http://numbersapi.com/" + number;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
