package com.example.demo.service;

import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Raven
 */
@Service
public class NextService {

    //实体 属性 属性值
    public String addProp(String name, String propName,String value) throws FileNotFoundException {
        String SOURCE = "http://www.semanticweb.org/raven/ontologies/2020/10/baseOnt";
        String NS = SOURCE + "#";
        String message = "";
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read("output.owl");
        OntClass sample = baseOnt.getOntClass(NS+name);
        ObjectProperty prop = baseOnt.getObjectProperty(NS + propName);

        if(sample!=null)
        {
            if(prop == null) {
                ObjectProperty newprop = baseOnt.createObjectProperty(NS + propName);
                sample.addProperty(newprop,value);
                message =  "Have added property for class!";
            }
            if(prop !=null){
                sample.addProperty(prop,value);
                message =  "Have added property for class!";
            }
        }


        if(sample == null) {
            message = "no such class!";
        }

        FileOutputStream fOut;
        fOut = new FileOutputStream("output.owl");
        baseOnt.write(fOut);
        return message;
    }
    //实体 关系 实体

    public String addConn(String Aname, String conName,String Bname) throws FileNotFoundException {
        String SOURCE = "http://www.semanticweb.org/raven/ontologies/2020/10/baseOnt";
        String NS = SOURCE + "#";
        String message = "";
        OntModel baseOnt = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        baseOnt.read("output.owl");
        OntClass sample1 = baseOnt.getOntClass(NS + Aname);
        OntClass sample2 = baseOnt.getOntClass(NS + Bname);
        ObjectProperty prop = baseOnt.createObjectProperty(NS + conName);

        if (sample1 == null || sample2 == null) {
            return "no such ontClasses for building connections!";
        }
        sample1.addProperty(prop,sample2);

        FileOutputStream fOut;
        fOut = new FileOutputStream("output.owl");
        baseOnt.write(fOut);
        message = "have already added the connection required!";
        return message;
    }

        //为属性增加range和domain
    public String addDMForProperty(String name, String domain, String range) throws FileNotFoundException {
        String SOURCE = "http://www.semanticweb.org/raven/ontologies/2020/10/baseOnt";
        String NS = SOURCE + "#";
        String message = "Have Added";
        System.out.println(name + domain + range);
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read("output.owl");
        ObjectProperty prop = baseOnt.getObjectProperty(NS + name);
        OntClass domainClass = baseOnt.getOntClass(NS + domain);
        OntClass rangeClass = baseOnt.getOntClass(NS + range);
        if(prop == null)
        {
            message = "no such property!";
            return message;
        }
        if(prop != null)
        {
            if(domainClass != null)
            {
                prop.addDomain(domainClass);
                System.out.println("domain added");
            }
            if(domainClass == null && domain != null) {
                OntClass myDomain = baseOnt.createClass(NS + domain);
                prop.addDomain(myDomain);
            }


            if(rangeClass != null)
            {
                prop.addRange(rangeClass);
                System.out.println("range added");
            }
            if(rangeClass == null && range != null) {
                OntClass myRange = baseOnt.createClass(NS + domain);
                prop.addRange(myRange);
            }

        }
        FileOutputStream fOut;
        fOut = new FileOutputStream("output.owl");
        baseOnt.write(fOut);
        message = "have already added the domain and range required!";
        return message;
    }

}
