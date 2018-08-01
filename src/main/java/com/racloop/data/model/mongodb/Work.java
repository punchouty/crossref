package com.racloop.data.model.mongodb;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Document(collection = "works")
public class Work {

    @Id
    @Field("_id")
    private String id;
    private String publisher;
    private String issue;
    private String volume;
    private String page;
    @Field("short-container-title")
    private HashSet<String> shortContainerTitle = new HashSet<>();
    @Field("container-title")
    private HashSet<String> containerTitle = new HashSet<>();
    @Field("title")
    private HashSet<String> title = new HashSet<>();
    @Field("subtitle")
    private HashSet<String> subtitle = new HashSet<>();
    @Field("issued")
    private Issued issued;
    @Field("DOI")
    @Indexed
    private String doi;
    private String type;
    @Field("ISSN")
    private HashSet<String> issn = new HashSet<>();
    private ArrayList<Author> author = new ArrayList<>();
    @Field("subject")
    private HashSet<String> subject = new HashSet<>();

    public String getReferenceText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Author author1 : author) {
            if(!StringUtils.isBlank(author1.getGiven())) stringBuilder.append(author1.getGiven() + " ");
            if(!StringUtils.isBlank(author1.getFamily())) stringBuilder.append(author1.getFamily() + ", ");
        }
        if(issued != null) {
            List<List<Integer>> dateParts = issued.getDateParts();
            if(dateParts != null && dateParts.size() >= 1) {
                List<Integer> parts = dateParts.get(0);
                for (Integer integer : parts) {
                    if(integer > 1900 && integer < 2050) {
                        stringBuilder.append(integer + " ");
                    }
                }
            }
        }
        if(title.size() >= 1) {
            for (String s : title) {
                stringBuilder.append(s + ", ");
                break;
            }
        }
        if(subtitle.size() >= 1) {
            stringBuilder.append(" : ");
            for (String s : subtitle) {
                stringBuilder.append(s + ", ");
                break;
            }
        }
        if(containerTitle.size() >= 1) {
            for (String s : containerTitle) {
                stringBuilder.append(s + ", ");
                break;
            }
        }
        if(shortContainerTitle.size() >= 1) {
            for (String s : shortContainerTitle) {
                stringBuilder.append(s + ", ");
                break;
            }
        }
        if(!StringUtils.isBlank(volume)) stringBuilder.append(volume + " ");
        if(!StringUtils.isBlank(issue)) stringBuilder.append(issue + " ");
        if(!StringUtils.isBlank(page)) stringBuilder.append(page + ", ");
        if(!StringUtils.isBlank(doi)) stringBuilder.append(doi + " ");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Work{" +
                "id='" + id + '\'' +
                ", publisher='" + publisher + '\'' +
                ", issue='" + issue + '\'' +
                ", volume='" + volume + '\'' +
                ", page='" + page + '\'' +
                ", shortContainerTitle=" + shortContainerTitle +
                ", containerTitle=" + containerTitle +
                ", title=" + title +
                ", subtitle=" + subtitle +
                ", issued=" + issued +
                ", doi='" + doi + '\'' +
                ", type='" + type + '\'' +
                ", issn=" + issn +
                ", author=" + author +
                ", subject=" + subject +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public HashSet<String> getShortContainerTitle() {
        return shortContainerTitle;
    }

    public void setShortContainerTitle(HashSet<String> shortContainerTitle) {
        this.shortContainerTitle = shortContainerTitle;
    }

    public HashSet<String> getContainerTitle() {
        return containerTitle;
    }

    public void setContainerTitle(HashSet<String> containerTitle) {
        this.containerTitle = containerTitle;
    }

    public HashSet<String> getTitle() {
        return title;
    }

    public void setTitle(HashSet<String> title) {
        this.title = title;
    }

    public HashSet<String> getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(HashSet<String> subtitle) {
        this.subtitle = subtitle;
    }

    public Issued getIssued() {
        return issued;
    }

    public void setIssued(Issued issued) {
        this.issued = issued;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashSet<String> getIssn() {
        return issn;
    }

    public void setIssn(HashSet<String> issn) {
        this.issn = issn;
    }

    public ArrayList<Author> getAuthor() {
        return author;
    }

    public void setAuthor(ArrayList<Author> author) {
        this.author = author;
    }

    public HashSet<String> getSubject() {
        return subject;
    }

    public void setSubject(HashSet<String> subject) {
        this.subject = subject;
    }
}
