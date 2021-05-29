package com.github.antezovko23.sortdetective.configuration.parameterConverting;

import org.springframework.core.convert.converter.Converter;


import com.github.antezovko23.sortdetective.model.sorts.ISorter;

import org.springframework.stereotype.Component;

@Component
public class SortTypeConverter implements Converter<String, ISorter> {

    @Override
    public ISorter convert(String buttonAlgorithm) {
        try {

            return Class.forName("com.github.antezovko23.sortdetective.model.sorts." + buttonAlgorithm)
                        .asSubclass(ISorter.class)
                        .getDeclaredConstructor()
                        .newInstance();

        } catch (Exception e) {

                return null;
        }
    }


    
}