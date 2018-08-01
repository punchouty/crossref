package com.racloop.data.model.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;

public class Reference {

    @Id
    private String id;
    @Indexed
    private String title;
    @Indexed
    private String subtitle;
    @Indexed
    private String originalTitle;
    @Indexed
    private String containerTitle;
    @Indexed
    private HashSet<String> containerTitles = new HashSet<>();
    @Indexed
    private String containerShortTitle;
    private String volume;
    private String issue;
    private String page;
    @Indexed
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date publicationDate;
    @Indexed
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date indexedDate;
    @Indexed
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date depositedDate;
    private String type;
    @Indexed
    private String publisher;
    @Indexed
    private String publisherLocation;
    @Indexed
    private String doi;
    @Indexed
    private String issnPrint;
    @Indexed
    private String issnElectronic;
    @Indexed
    private String isbnPrint;
    @Indexed
    private String isbnElectronic;
    @Indexed
    private String language;
    private HashSet<Author> authors = new HashSet<>();

}
