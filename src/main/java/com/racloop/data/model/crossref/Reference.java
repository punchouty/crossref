package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "key",
        "doi-asserted-by",
        "first-page",
        "DOI",
        "article-title",
        "volume",
        "author",
        "year",
        "journal-title",
        "unstructured",
        "issue",
        "volume-title",
        "edition"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reference {

    @JsonProperty("key")
    private String key;
    @JsonProperty("doi-asserted-by")
    private String doiAssertedBy;
    @JsonProperty("first-page")
    private String firstPage;
    @JsonProperty("DOI")
    private String dOI;
    @JsonProperty("article-title")
    private String articleTitle;
    @JsonProperty("volume")
    private String volume;
    @JsonProperty("author")
    private String author;
    @JsonProperty("year")
    private String year;
    @JsonProperty("journal-title")
    private String journalTitle;
    @JsonProperty("unstructured")
    private String unstructured;
    @JsonProperty("issue")
    private String issue;
    @JsonProperty("volume-title")
    private String volumeTitle;
    @JsonProperty("edition")
    private String edition;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "Reference{" +
                "key='" + key + '\'' +
                ", doiAssertedBy='" + doiAssertedBy + '\'' +
                ", firstPage='" + firstPage + '\'' +
                ", dOI='" + dOI + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", volume='" + volume + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", journalTitle='" + journalTitle + '\'' +
                ", unstructured='" + unstructured + '\'' +
                ", issue='" + issue + '\'' +
                ", volumeTitle='" + volumeTitle + '\'' +
                ", edition='" + edition + '\'' +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("doi-asserted-by")
    public String getDoiAssertedBy() {
        return doiAssertedBy;
    }

    @JsonProperty("doi-asserted-by")
    public void setDoiAssertedBy(String doiAssertedBy) {
        this.doiAssertedBy = doiAssertedBy;
    }

    @JsonProperty("first-page")
    public String getFirstPage() {
        return firstPage;
    }

    @JsonProperty("first-page")
    public void setFirstPage(String firstPage) {
        this.firstPage = firstPage;
    }

    @JsonProperty("DOI")
    public String getDOI() {
        return dOI;
    }

    @JsonProperty("DOI")
    public void setDOI(String dOI) {
        this.dOI = dOI;
    }

    @JsonProperty("article-title")
    public String getArticleTitle() {
        return articleTitle;
    }

    @JsonProperty("article-title")
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @JsonProperty("volume")
    public String getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(String volume) {
        this.volume = volume;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("journal-title")
    public String getJournalTitle() {
        return journalTitle;
    }

    @JsonProperty("journal-title")
    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    @JsonProperty("unstructured")
    public String getUnstructured() {
        return unstructured;
    }

    @JsonProperty("unstructured")
    public void setUnstructured(String unstructured) {
        this.unstructured = unstructured;
    }

    @JsonProperty("issue")
    public String getIssue() {
        return issue;
    }

    @JsonProperty("issue")
    public void setIssue(String issue) {
        this.issue = issue;
    }

    @JsonProperty("volume-title")
    public String getVolumeTitle() {
        return volumeTitle;
    }

    @JsonProperty("volume-title")
    public void setVolumeTitle(String volumeTitle) {
        this.volumeTitle = volumeTitle;
    }

    @JsonProperty("edition")
    public String getEdition() {
        return edition;
    }

    @JsonProperty("edition")
    public void setEdition(String edition) {
        this.edition = edition;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}