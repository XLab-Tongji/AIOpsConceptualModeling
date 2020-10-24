package com.example.demo.controller;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Person;
import com.example.demo.service.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    @RequestMapping("/person/{given}/{family}")
    public List<Person> getPersonList(@PathVariable String given, @PathVariable String family) throws FileNotFoundException {
        Person p1 = new Person("http://somewhere/" + given + family, given, family);

        Model model = ModelFactory.createDefaultModel();

        Resource tmp = model.createResource(p1.getPersonUri());
        tmp.addProperty(VCARD.FN, p1.getFullName());
        tmp.addProperty(VCARD.N,
                model.createResource()
                        .addProperty(VCARD.Given, p1.getGivenName())
                        .addProperty(VCARD.Family, p1.getFamilyName()));

        //Model write
        model.write(System.out);
        System.out.println();
        FileOutputStream fOut;
        fOut = new FileOutputStream("test.rdf");
        model.write(fOut, "RDF/XML-ABBREV");

        List<Person> testList = new ArrayList<>();
        testList.add(p1);
        return testList;
    }
    @PostMapping("/addClass")
    public String addClass(@RequestParam("name") String name,
                           @RequestParam("sub") String sub){
        addClass(name,sub);
        return name + sub;
    }

}
