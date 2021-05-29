package com.github.antezovko23.sortdetective.model.listTypes;


import java.util.ArrayList;
import java.util.List;


import com.github.antezovko23.sortdetective.configuration.parameterConverting.ListTypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class AllLists {

    @Autowired
    ListTypeConverter converter;

    public List<IList> getAllListTypes(){

        String[] listTypes = {"InOrder", "AlmostInOrder", "RandomOrder", "ReverseOrder"};
        List<IList> listTypeInstances = new ArrayList<>();

        for (String className : listTypes) {

            listTypeInstances.add(converter.convert(className));

        }
        
        return listTypeInstances;

    }
    

    
}