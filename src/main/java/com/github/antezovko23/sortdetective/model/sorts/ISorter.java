package com.github.antezovko23.sortdetective.model.sorts;

import com.github.antezovko23.sortdetective.service.Metrics;

import org.springframework.stereotype.Component;

@Component
public interface ISorter {


    abstract void sort(int list[], Metrics metrics);
    
}