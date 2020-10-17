package com.example.demo.model;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

public class RDFWriting {
    public static void main(String[] args){

        //Introduction
        String personURI = "http://somewhere/JohnSmith";
        String givenName = "John";
        String familyName = "Smith";
        String fullName = givenName + " " + familyName;
        Model model = ModelFactory.createDefaultModel();

        Resource johnSmith = model.createResource(personURI);
        johnSmith.addProperty(VCARD.FN, fullName);
        johnSmith.addProperty(VCARD.N,
                model.createResource()
                        .addProperty(VCARD.Given, givenName)
                        .addProperty(VCARD.Family, familyName));

        //Model write
        model.write(System.out);
        System.out.println();
        model.write(System.out, "RDF/XML-ABBREV");
        System.out.println();
        model.write(System.out, "N-TRIPLE");
    }
}
