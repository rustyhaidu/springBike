package com.angular.fullstack.controller;

import com.angular.fullstack.model.Bike;
import com.angular.fullstack.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {

    @Autowired
    BikeRepository bikeRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike){
        bikeRepository.save(bike);
    }

    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") long id){
        return bikeRepository.findById(id).get();
    }

    @GetMapping
    public List<Bike> list() {
        return bikeRepository.findAll();
    }
}
