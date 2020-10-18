package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raven
 */
@RestController
@RequestMapping("/init")
public class InitController {

    @RequestMapping("/index")
    public String sayHello(){
        return "hello index";
    }

    @RequestMapping("/person")
    public List<Person> getPersonList(){
        Person p1 = new Person("Edward", "Kenway");
        List<Person> testList = new ArrayList<>();
        testList.add(p1);
        return testList;
    }


}
