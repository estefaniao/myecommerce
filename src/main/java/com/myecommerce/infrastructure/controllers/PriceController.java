package com.myecommerce.infrastructure.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myecommerce.application.services.PriceService;
import com.myecommerce.domain.models.Price;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<Price> getPrice(
            @RequestParam Long brandId, @RequestParam Long productId, @RequestParam String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        Optional<Price> price = priceService.getPriceByParams(brandId, productId, dateTime);

        if (!price.isEmpty()) {
            return new ResponseEntity<>(price.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Price>> getAllPrice() {	
    	return new ResponseEntity<>(priceService.getAllPrices(),HttpStatus.OK);
    }
}

