package com.example.demo.controller;

import com.example.demo.dao.OntDao;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

/**
 * @author Raven
 */
@RestController
@RequestMapping("/init")
public class OntController {
    OntDao ontDao = new OntDao();

    @RequestMapping("/index")
    public String sayHello(){
        return "hello index";
    }

    @PostMapping("/addClass")
    public String addClass(@RequestParam("name") String name) throws FileNotFoundException {

        return ontDao.createClass(name);
    }

    @PostMapping("/deleteRes")
    public String deleteRes(@RequestParam("name") String name){
        return ontDao.removeRes(name);
    }

    @PostMapping("/addProperty")
    public String addProp(@RequestParam("name") String name,
                          @RequestParam("parentName") String parentName,
                          @RequestParam(value = "value",required = false) String value) throws FileNotFoundException {
        return ontDao.addProp(name, parentName, value);
    }

    @PostMapping("/optimizeProperty")
    public String optProp(@RequestParam("name") String name,
                          @RequestParam(value = "domain", required = false) String domain,
                          @RequestParam(value = "range", required = false) String range) throws FileNotFoundException {
        return ontDao.optProp(name, domain, range);
    }

}
