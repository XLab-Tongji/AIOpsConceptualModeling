package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.*;

import java.io.FileNotFoundException;

/**
 * @author Raven
 */
@RestController
@RequestMapping("/init")
public class InitController {
    InitService init = new InitService();

    @RequestMapping("/index")
    public String sayHello(){
        return "hello index";
    }

    @PostMapping("/addClass")
    public String addClass(@RequestParam("name") String name,
                           @RequestParam(value = "subOf",required = false) String subOf) throws FileNotFoundException {

        String message = init.createClass(name,subOf);
        return message;
    }

    @PostMapping("/deleteRes")
    public String deleteRes(@RequestParam("name") String name){
        String message = init.removeRes(name);
        return message;
    }

    @PostMapping("/addProperty")
    public String addProp(@RequestParam("name") String name,
                          @RequestParam("parentName") String parentName,
                          @RequestParam(value = "value",required = false) String value) throws FileNotFoundException {
        String message = init.addProp(name, parentName, value);
        return message;
    }

    @PostMapping("/optimizeProperty")
    public String optProp(@RequestParam("name") String name,
                          @RequestParam(value = "domain", required = false) String domain,
                          @RequestParam(value = "range", required = false) String range) throws FileNotFoundException {
        String message = init.optProp(name, domain, range);
        return message;
    }

}
