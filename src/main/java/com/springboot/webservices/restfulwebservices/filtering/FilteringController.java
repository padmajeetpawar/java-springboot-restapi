package com.springboot.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retriveSomeBean() {
        return new SomeBean(1, "abc" , "abc123");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retriveSomeBeanList() {
        return Arrays.asList(
                new SomeBean(1, "abc" , "abc123"),
                new SomeBean(2, "pqr" , "pqr123"),
                new SomeBean(3, "xyz" , "xyz123")
        );
    }
}
