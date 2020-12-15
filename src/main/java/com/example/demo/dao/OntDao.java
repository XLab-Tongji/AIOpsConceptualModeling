package com.example.demo.dao;

import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.XSD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Raven
 */

public class OntDao {
    private final String NS;
    String result;
    public OntDao(String layer) {
        String source = "http://www.semanticweb.org/raven/ontologies/2020/10/";
        source = source + layer;
        this.NS = source + "#";
        if(layer.equals("API")){result="./data/API.owl";}
        else if(layer.equals("SDK")){result="./data/SDK.owl";}
        else{result="./data/view model.owl";}
    }


    public String createClass(String newClass) throws FileNotFoundException {
        String message = "Class created";
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read(result);
        baseOnt.createClass(NS + newClass);
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
            prop.addDomain(domainClass);
            System.out.println("Domain added");
            prop.addRange(rangeClass);
            System.out.println("Range added");
        }
        else {
            if(domain == null || domainClass == null){
                message="Domain not exist!";
            }
            if(range == null || rangeClass == null){
                message="Range not exist!";
            }
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
    public void addDataProp(String father, String name, String type, String desc) throws FileNotFoundException {
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read(result);

        String label = "label";
        String integer = "integer";
        String ID = "ID";

        OntClass baseOntOntClass = baseOnt.getOntClass(NS + father);

        if(type.equals(label))
        {
            AnnotationProperty description = baseOnt.createAnnotationProperty(NS + name);
            baseOntOntClass.addProperty(description, desc);
        }
        else{
            OntProperty dataProp = baseOnt.createDatatypeProperty(NS + name);
            dataProp.addDomain(baseOntOntClass);
            if(desc.equals(integer)){
                dataProp.addRange(XSD.integer);
            }
            if(desc.equals(ID)){
                dataProp.addRange(XSD.ID);
            }
        }

        FileOutputStream fOut;
        fOut = new FileOutputStream(result);
        baseOnt.write(fOut);
    }
}