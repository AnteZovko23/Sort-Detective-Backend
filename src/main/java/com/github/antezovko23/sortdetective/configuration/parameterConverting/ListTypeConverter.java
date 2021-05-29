package com.github.antezovko23.sortdetective.configuration.parameterConverting;

import com.github.antezovko23.sortdetective.model.listTypes.IList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ListTypeConverter implements Converter<String, IList> {

    @Override
    public IList convert(String listType) {
        try {

            return Class.forName("com.github.antezovko23.sortdetective.model.listTypes.listImplementations." + listType)
                        .asSubclass(IList.class)
                        .getDeclaredConstructor()
                        .newInstance();

        } catch (Exception e) {

                return null;
        }
    }
    
    
}