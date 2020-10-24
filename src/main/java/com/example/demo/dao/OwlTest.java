package com.example.demo.dao;

import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

/**
 * @author Raven
 */
public class OwlTest {
    public static void main(String[] args){
        String SOURCE = "http://www.semanticweb.org/raven/ontologies/2020/10/baseOnt";
        String NS = SOURCE + "#";
        OntModel baseOnt = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        OntClass paper = baseOnt.createClass(NS + "paper");

        OntClass pen = baseOnt.createClass(NS + "pen");
        paper.addSubClass(pen);

        OntClass damn = baseOnt.createClass(NS + "damn");

        ObjectProperty hasFucked = baseOnt.createObjectProperty(NS + "hasFucked");
        hasFucked.addDomain(paper);
        hasFucked.addRange(pen);
        baseOnt.write(System.out);
    }
}
