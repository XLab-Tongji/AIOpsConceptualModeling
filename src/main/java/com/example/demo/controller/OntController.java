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
    String object = "DataModel";
    OntDao ontDao = new OntDao(object);

    @RequestMapping("/index")
    public String sayHello(){
        return "hello index";
    }

    //创建类的接口
    @PostMapping("/addClass")
    public String addClass(@RequestParam("name") String name) throws FileNotFoundException {

        return ontDao.createClass(name);
    }

    //删除资源的接口
    @PostMapping("/deleteRes")
    public String deleteRes(@RequestParam("name") String name){
        return ontDao.removeRes(name);
    }

    //添加属性的接口
    @PostMapping("/addProperty")
    public String addProp(@RequestParam("name") String name,
                          @RequestParam("parentName") String parentName,
                          @RequestParam(value = "value",required = false) String value) throws FileNotFoundException {
        return ontDao.addProp(name, parentName, value);
    }

    //添加数据属性的接口
    @PostMapping("/optimizeProperty")
    public String optProp(@RequestParam("name") String name,
                          @RequestParam(value = "domain", required = false) String domain,
                          @RequestParam(value = "range", required = false) String range) throws FileNotFoundException {
        return ontDao.optProp(name, domain, range);
    }

}
