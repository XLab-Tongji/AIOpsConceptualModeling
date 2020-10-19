package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/person/{given}/{family}")
    public List<Person> getPersonList(@PathVariable String given, @PathVariable String family){
        Person p1 = new Person("http://somewhere/" + given + family, given, family);
        List<Person> testList = new ArrayList<>();
        testList.add(p1);
        return testList;
    }


}
