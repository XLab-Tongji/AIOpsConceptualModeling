package com.example.demo.service;

import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Raven
 */
@Service
public class InitService {
    public String createClass(String name, String subOf) throws FileNotFoundException {
        String SOURCE = "http://www.semanticweb.org/raven/ontologies/2020/10/baseOnt";
        String NS = SOURCE + "#";
        String message = "class created";
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read("output.owl");
        OntClass sample = baseOnt.createClass(NS + name);
        OntClass sub = baseOnt.getOntClass(NS + subOf);
        if(sub == null) {
            System.out.println("the parent class does not exist");
            message = "the parent class does not exist";
        }
        else{
            sub.addSubClass(sample);
        }
        FileOutputStream fOut;
        fOut = new FileOutputStream("output.owl");
        baseOnt.write(fOut);
        return message;
    }

    public String optProp(String name, String domain, String range) throws FileNotFoundException {
        String SOURCE = "http://www.semanticweb.org/raven/ontologies/2020/10/baseOnt";
        String NS = SOURCE + "#";
        String message = "property optimized";
        System.out.println(name + domain + range);
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read("output.owl");
        ObjectProperty prop = baseOnt.createObjectProperty(NS + name);
        OntClass domainClass = baseOnt.getOntClass(NS + domain);
        OntClass rangeClass = baseOnt.getOntClass(NS + range);
        if(domain != null && domainClass != null)
        {
            prop.addDomain(domainClass);
            System.out.println("domain added");
        }
        if(range != null && rangeClass != null)
        {
            prop.addRange(rangeClass);
            System.out.println("range added");
        }
        FileOutputStream fOut;
        fOut = new FileOutputStream("output.owl");
        baseOnt.write(fOut);
        return message;
    }
    public String addProp(String name, String parentName, String value) throws FileNotFoundException {
        String SOURCE = "http://www.semanticweb.org/raven/ontologies/2020/10/baseOnt";
        String NS = SOURCE + "#";
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read("output.owl");

        String message;
        System.out.println(name + parentName + value);
        ObjectProperty prop = baseOnt.createObjectProperty(NS + name);
        OntClass parentClass = baseOnt.getOntClass(NS + parentName);
        ObjectProperty parentProp = baseOnt.getObjectProperty(NS + parentName);
        if(parentClass != null)
        {
            parentClass.addProperty(prop,value);
            message = "property created";
        }
        else if(parentProp != null)
        {
            parentProp.addProperty(prop,value);
            message = "sub property created";
        }
        else{
            message = "parent does not exist";
        }
        FileOutputStream fOut;
        fOut = new FileOutputStream("output.owl");
        baseOnt.write(fOut);
        return message;
    }

    public String removeRes(String name) {
        String SOURCE = "http://www.semanticweb.org/raven/ontologies/2020/10/baseOnt";
        String NS = SOURCE + "#";
        String message = "resource removed";
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read("output.owl");
        OntClass sample = baseOnt.getOntClass(NS + name);
        if(sample == null) {
            System.out.println("class does not exist");
            message = "class does not exist";
        }
        else{
            sample.remove();
        }
        return message;
    }
}