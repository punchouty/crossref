package com.racloop.data.model.mongodb;

import java.util.HashSet;

public class Author {

    private String suffix;
    private String given;
    private String family;
    private String sequence;
    private HashSet<Affiliation> affiliation = new HashSet<>();

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public HashSet<Affiliation> getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(HashSet<Affiliation> affiliation) {
        this.affiliation = affiliation;
    }
}
