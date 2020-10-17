package com.example.demo.model;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

/**
 * @author Raven
 */
public class RdfReading {

    public static void main(String[] args){
        {
            OntModel ontModel=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
            ontModel.read("file:C:\\Users\\Administrator\\Documents\\GitHub\\AIOpsConceptualModeling\\src\\main\\java\\com\\example\\demo\\model\\resources.rdf");
            ontModel.write(System.out);
            StmtIterator iter = ontModel.listStatements(new SimpleSelector(null, VCARD.FN, (RDFNode)null));
            if(iter.hasNext()){
                System.out.println("The database contains vcard for:");
                while(iter.hasNext()){
                    System.out.println(" "+iter.nextStatement().getString());
                }
            }else{
                System.out.println("No v cards were found in the database");
            }

        }
    }
}
