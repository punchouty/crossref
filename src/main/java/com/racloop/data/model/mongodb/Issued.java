package com.racloop.data.model.mongodb;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

public class Issued {

    @Field("date-parts")
    private  List<List<Integer>>  dateParts = new ArrayList<>();

    public List<List<Integer>> getDateParts() {
        return dateParts;
    }

    public void setDateParts(List<List<Integer>> dateParts) {
        this.dateParts = dateParts;
    }
}
