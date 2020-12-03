package com.example.demo.controller;

import com.example.demo.dao.YamlDao;
import com.github.jsonldjava.utils.Obj;
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

    String layer;
    YamlService yamlService = new YamlService(layer);
    @RequestMapping("/init")
    public AbstractModel yamlToProps() throws FileNotFoundException {
        return yamlService.YamlToProps();
    }
}
