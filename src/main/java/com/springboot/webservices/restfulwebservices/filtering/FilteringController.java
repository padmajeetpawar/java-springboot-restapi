package com.springboot.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retriveSomeBean() {
        SomeBean someBean = new SomeBean(1, "abc" , "abc123");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "userName");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("someBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;

    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue retriveSomeBeanList() {
        List<SomeBean> userList =  Arrays.asList(
                new SomeBean(1, "abc" , "abc123"),
                new SomeBean(2, "pqr" , "pqr123"),
                new SomeBean(3, "xyz" , "xyz123")
        );
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "userName");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("someBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(userList);
        mapping.setFilters(filters);

        return mapping;
    }
}
