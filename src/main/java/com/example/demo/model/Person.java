package com.example.demo.model;

/**
 * @author Raven
 */
public class Person {
    private String personUri;
    private String givenName;
    private String familyName;
    private String fullName;

    public Person(String personUri, String givenName, String familyName){
        this.personUri = personUri;
        this.givenName = givenName;
        this.familyName = familyName;
        this.fullName = givenName + " " +familyName;
    }

    public String getGivenName(){
        return givenName;
    }
    public String getFamilyName(){
        return familyName;
    }
    public String getPersonUri(){ return personUri; }
    public String getFullName(){ return fullName; }
}
