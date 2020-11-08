package com.example.demo.dao;

import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Raven
 */
@Component
public class OntDao {
    private final String NS;
    String result = "./data/output.owl";

    public OntDao() {
        String source = "http://www.semanticweb.org/raven/ontologies/2020/10/baseOnt";
        this.NS = source + "#";
    }


    public String createClass(String newClass) throws FileNotFoundException {
        String message = "Class created";
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read(result);
        OntClass sample = baseOnt.createClass(NS + newClass);
        FileOutputStream fOut;
        fOut = new FileOutputStream(result);
        baseOnt.write(fOut);
        return message;
    }

    public String optProp(String name, String domain, String range) throws FileNotFoundException {
        String message = "Property optimized";
        System.out.println(name + domain + range);
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read(result);
        ObjectProperty prop = baseOnt.createObjectProperty(NS + name);
        OntClass domainClass = baseOnt.getOntClass(NS + domain);
        OntClass rangeClass = baseOnt.getOntClass(NS + range);
        if(domain != null && domainClass != null && range != null && rangeClass != null)
        {
            domainClass.addProperty(prop,rangeClass);
            System.out.println("Domain added");
        }
        else{
            message="Domain not exist!";
        }
        FileOutputStream fOut;
        fOut = new FileOutputStream(result);
        baseOnt.write(fOut);
        return message;
    }


    public String addProp(String child, String parent, String value) throws FileNotFoundException {
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read(result);

        String message;
        System.out.println(child + parent + value);
        ObjectProperty prop = baseOnt.createObjectProperty(NS + child);
        OntClass parentClass = baseOnt.getOntClass(NS + parent);
        ObjectProperty parentProp = baseOnt.getObjectProperty(NS + parent);
        if(parentClass != null)
        {
            parentClass.addProperty(prop,value);
            message = "Property created";
        }
        else if(parentProp != null)
        {
            parentProp.addProperty(prop,value);
            message = "Sub property created";
        }
        else{
            message = "Parent does not exist";
        }
        FileOutputStream fOut;
        fOut = new FileOutputStream(result);
        baseOnt.write(fOut);
        return message;
    }

    public String removeRes(String name) {
        String message = "Resource removed";
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read(result);
        OntClass sample = baseOnt.getOntClass(NS + name);
        if(sample == null) {
            System.out.println("Class does not exist");
            message = "Class does not exist";
        }
        else{
            sample.remove();
        }
        return message;
    }
}