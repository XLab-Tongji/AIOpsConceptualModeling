package com.example.demo.controller;

import com.example.demo.dao.YamlDao;
import com.github.jsonldjava.utils.Obj;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.*;
import com.example.demo.model.*;

import java.io.FileNotFoundException;
import java.util.*;
import com.example.demo.service.YamlService;

/**
 * @author xjt
 */
@RestController
@RequestMapping("/yaml")
public class YamlController {

    @RequestMapping("/init/{layer}")

    public AbstractModel yamlToProps(@PathVariable String layer) throws FileNotFoundException {
        YamlService yamlService = new YamlService(layer);
        System.out.println(layer);
        return yamlService.YamlToProps();
    }
}
