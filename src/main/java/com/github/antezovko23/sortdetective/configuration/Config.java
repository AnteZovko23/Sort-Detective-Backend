package com.github.antezovko23.sortdetective.configuration;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.antezovko23.sortdetective.model.listTypes.AllLists;
import com.github.antezovko23.sortdetective.model.listTypes.IList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public HashMap<String, BigInteger> hashMap(){
        return new HashMap<String, BigInteger>();
    }
    
    @Bean
    public HashMap<String, HashMap<String, BigInteger>> hashmap2() {
        return new HashMap<String, HashMap<String, BigInteger>>();
    }
    
        @Bean
    public int[] list() {
        int[] list = {};
        return list;
    }
    
    @Bean
    public AllLists allListTypes(){

        return new AllLists();

    }

    // @Bean
    // public void allLists() {
        
       

        
    // }


    
}