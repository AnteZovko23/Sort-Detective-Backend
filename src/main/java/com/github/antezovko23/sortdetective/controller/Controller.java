package com.github.antezovko23.sortdetective.controller;

import java.io.IOException;
import java.util.HashMap;

import com.github.antezovko23.sortdetective.model.listTypes.IList;
import com.github.antezovko23.sortdetective.model.sorts.ISorter;
import com.github.antezovko23.sortdetective.service.MetricsData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// @CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("sortDetective/")
public class Controller {

    @Autowired
    MetricsData sortData;


    @GetMapping("/getSortData")
    public HashMap<String, String> performExperiment(@RequestParam String algName, @RequestParam ISorter buttonAlgorithm,
            @RequestParam Integer listSize, @RequestParam IList listType) throws IOException {

        try {

            return sortData.getSortData(algName, buttonAlgorithm, listSize, listType);


        } catch (Exception e) {
            
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

        }

    }


    
}