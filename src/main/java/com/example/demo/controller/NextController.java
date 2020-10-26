package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.*;

import java.io.FileNotFoundException;

/**
 * @author Raven
 */
@RestController
@RequestMapping("/next")
public class NextController {
    NextService init = new NextService();

    @PostMapping("/addProperty")//实体 属性 属性值
    public String addProp(@RequestParam("name") String name,
                          @RequestParam("propName") String propName,
                          @RequestParam("value") String value)
            throws FileNotFoundException {
        String message = init.addProp(name, propName,value);
        return message;
    }

    @PostMapping("/addConnection")//实体 关系 实体
    public String addConn(@RequestParam("Aname") String Aname,
                          @RequestParam("conName") String conName,
                          @RequestParam("Bname") String Bname )
            throws FileNotFoundException {
        String message = init.addConn(Aname, conName,Bname);
        return message;
    }



    @PostMapping("/addDomainAndRange")//为属性增添domain和range
    public String addDM(@RequestParam("name") String name,
                        @RequestParam(value = "domain",required = false) String domain,
                        @RequestParam(value = "range",required = false) String range) throws FileNotFoundException {
        String message = init.addDMForProperty(name, domain, range);
        return message;
    }

}
