package com.example.demo.model;

/**
 * @author Raven
 */
public class Person {
    private int ID;
    private String givenName;
    private String familyName;

    public Person(String givenName, String familyName){
        this.givenName = givenName;
        this.familyName = familyName;
    }

    public String getGivenName(){
        return givenName;
    }
    public String getFamilyName(){
        return familyName;
    }
    public int getID(){
        return ID;
    }
}
