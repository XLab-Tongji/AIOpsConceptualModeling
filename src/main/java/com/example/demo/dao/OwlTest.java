package com.example.demo.dao;

import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

/**
 * @author Raven
 */
public class OwlTest {
    public static void main(String[] args) throws FileNotFoundException {
        String SOURCE = "http://www.semanticweb.org/raven/ontologies/2020/10/baseOnt";
        String NS = SOURCE + "#";
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        baseOnt.read("output.owl");

        OntClass paper = baseOnt.createClass(NS + "thing");

        for(Iterator iter = baseOnt.listClasses(); iter.hasNext();)
        {
            //String c = iter.next().toString();
            //c.replace(NS, "1");
            System.out.println(" "+iter.next().toString());
        }
        baseOnt.write(System.out);
        FileOutputStream fOut;
        fOut = new FileOutputStream("output.owl");
        baseOnt.write(fOut);

    }
}
