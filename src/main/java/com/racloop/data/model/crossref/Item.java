package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "indexed",
        "reference-count",
        "publisher",
        "issue",
        "license",
        "funder",//
        "content-domain",
        "short-container-title",
        "published-print",
        "DOI",
        "type",
        "created",
        "page",
        "source",
        "is-referenced-by-count",
        "title",
        "prefix",
        "volume",
        "author",
        "member",
        "event",//
        "container-title",
        "link",
        "deposited",
        "score",
        "subtitle",//
        "short-title",//
        "issued",
        "references-count",
        "alternative-id",
        "URL",
        "ISSN",
        "issn-type",
        "subject",
        "published-online",
        "original-title",
        "abstract",
        "reference",
        "relation",
        "archive",
        "article-number"//
})
public class Item {

    @JsonProperty("indexed")
    private Indexed indexed;
    @JsonProperty("reference-count")
    private Integer referenceCount;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("issue")
    private String issue;
    @JsonProperty("license")
    private List<License> license = null;
    @JsonProperty("funder")
    private List<Funder> funder = null;
    @JsonProperty("content-domain")
    private ContentDomain contentDomain;
    @JsonProperty("short-container-title")
    private List<String> shortContainerTitle = null;
    @JsonProperty("published-print")
    private PublishedPrint publishedPrint;
    @JsonProperty("DOI")
    private String dOI;
    @JsonProperty("type")
    private String type;
    @JsonProperty("created")
    private Created created;
    @JsonProperty("page")
    private String page;
    @JsonProperty("source")
    private String source;
    @JsonProperty("is-referenced-by-count")
    private Integer isReferencedByCount;
    @JsonProperty("title")
    private List<String> title = null;
    @JsonProperty("prefix")
    private String prefix;
    @JsonProperty("volume")
    private String volume;
    @JsonProperty("author")
    private List<Author> author = null;
    @JsonProperty("member")
    private String member;
    @JsonProperty("container-title")
    private List<String> containerTitle = null;
    @JsonProperty("link")
    private List<Link> link = null;
    @JsonProperty("deposited")
    private Deposited deposited;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("subtitle")
    private List<Object> subtitle = null;
    @JsonProperty("short-title")
    private List<Object> shortTitle = null;
    @JsonProperty("issued")
    private Issued issued;
    @JsonProperty("references-count")
    private Integer referencesCount;
    @JsonProperty("alternative-id")
    private List<String> alternativeId = null;
    @JsonProperty("URL")
    private String uRL;
    @JsonProperty("ISSN")
    private List<String> iSSN = null;
    @JsonProperty("issn-type")
    private List<IssnType> issnType = null;
    @JsonProperty("subject")
    private List<String> subject = null;
    @JsonProperty("published-online")
    private PublishedOnline publishedOnline;
    @JsonProperty("original-title")
    private List<String> originalTitle = null;
    @JsonProperty("abstract")
    private String _abstract;
    @JsonProperty("reference")
    private List<Reference> reference = null;
    @JsonProperty("relation")
    private Relation relation;
    @JsonProperty("archive")
    private List<String> archive = null;
    @JsonProperty("article-number")
    private String articleNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "Item{" +
                "indexed=" + indexed +
                ", referenceCount=" + referenceCount +
                ", publisher='" + publisher + '\'' +
                ", issue='" + issue + '\'' +
                ", license=" + license +
                ", funder=" + funder +
                ", contentDomain=" + contentDomain +
                ", shortContainerTitle=" + shortContainerTitle +
                ", publishedPrint=" + publishedPrint +
                ", dOI='" + dOI + '\'' +
                ", type='" + type + '\'' +
                ", created=" + created +
                ", page='" + page + '\'' +
                ", source='" + source + '\'' +
                ", isReferencedByCount=" + isReferencedByCount +
                ", title=" + title +
                ", prefix='" + prefix + '\'' +
                ", volume='" + volume + '\'' +
                ", author=" + author +
                ", member='" + member + '\'' +
                ", containerTitle=" + containerTitle +
                ", link=" + link +
                ", deposited=" + deposited +
                ", score=" + score +
                ", subtitle=" + subtitle +
                ", shortTitle=" + shortTitle +
                ", issued=" + issued +
                ", referencesCount=" + referencesCount +
                ", alternativeId=" + alternativeId +
                ", uRL='" + uRL + '\'' +
                ", iSSN=" + iSSN +
                ", issnType=" + issnType +
                ", subject=" + subject +
                ", publishedOnline=" + publishedOnline +
                ", originalTitle=" + originalTitle +
                ", _abstract='" + _abstract + '\'' +
                ", reference=" + reference +
                ", relation=" + relation +
                ", archive=" + archive +
                ", articleNumber='" + articleNumber + '\'' +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    @JsonProperty("indexed")
    public Indexed getIndexed() {
        return indexed;
    }

    @JsonProperty("indexed")
    public void setIndexed(Indexed indexed) {
        this.indexed = indexed;
    }

    @JsonProperty("reference-count")
    public Integer getReferenceCount() {
        return referenceCount;
    }

    @JsonProperty("reference-count")
    public void setReferenceCount(Integer referenceCount) {
        this.referenceCount = referenceCount;
    }

    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @JsonProperty("issue")
    public String getIssue() {
        return issue;
    }

    @JsonProperty("issue")
    public void setIssue(String issue) {
        this.issue = issue;
    }

    @JsonProperty("license")
    public List<License> getLicense() {
        return license;
    }

    @JsonProperty("license")
    public void setLicense(List<License> license) {
        this.license = license;
    }

    @JsonProperty("funder")
    public List<Funder> getFunder() {
        return funder;
    }

    @JsonProperty("funder")
    public void setFunder(List<Funder> funder) {
        this.funder = funder;
    }

    @JsonProperty("content-domain")
    public ContentDomain getContentDomain() {
        return contentDomain;
    }

    @JsonProperty("content-domain")
    public void setContentDomain(ContentDomain contentDomain) {
        this.contentDomain = contentDomain;
    }

    @JsonProperty("short-container-title")
    public List<String> getShortContainerTitle() {
        return shortContainerTitle;
    }

    @JsonProperty("short-container-title")
    public void setShortContainerTitle(List<String> shortContainerTitle) {
        this.shortContainerTitle = shortContainerTitle;
    }

    @JsonProperty("published-print")
    public PublishedPrint getPublishedPrint() {
        return publishedPrint;
    }

    @JsonProperty("published-print")
    public void setPublishedPrint(PublishedPrint publishedPrint) {
        this.publishedPrint = publishedPrint;
    }

    @JsonProperty("DOI")
    public String getDOI() {
        return dOI;
    }

    @JsonProperty("DOI")
    public void setDOI(String dOI) {
        this.dOI = dOI;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("created")
    public Created getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Created created) {
        this.created = created;
    }

    @JsonProperty("page")
    public String getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(String page) {
        this.page = page;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("is-referenced-by-count")
    public Integer getIsReferencedByCount() {
        return isReferencedByCount;
    }

    @JsonProperty("is-referenced-by-count")
    public void setIsReferencedByCount(Integer isReferencedByCount) {
        this.isReferencedByCount = isReferencedByCount;
    }

    @JsonProperty("title")
    public List<String> getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(List<String> title) {
        this.title = title;
    }

    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    @JsonProperty("prefix")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
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
    public List<Author> getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    @JsonProperty("member")
    public String getMember() {
        return member;
    }

    @JsonProperty("member")
    public void setMember(String member) {
        this.member = member;
    }

    @JsonProperty("container-title")
    public List<String> getContainerTitle() {
        return containerTitle;
    }

    @JsonProperty("container-title")
    public void setContainerTitle(List<String> containerTitle) {
        this.containerTitle = containerTitle;
    }

    @JsonProperty("link")
    public List<Link> getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(List<Link> link) {
        this.link = link;
    }

    @JsonProperty("deposited")
    public Deposited getDeposited() {
        return deposited;
    }

    @JsonProperty("deposited")
    public void setDeposited(Deposited deposited) {
        this.deposited = deposited;
    }

    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    @JsonProperty("subtitle")
    public List<Object> getSubtitle() {
        return subtitle;
    }

    @JsonProperty("subtitle")
    public void setSubtitle(List<Object> subtitle) {
        this.subtitle = subtitle;
    }

    @JsonProperty("short-title")
    public List<Object> getShortTitle() {
        return shortTitle;
    }

    @JsonProperty("short-title")
    public void setShortTitle(List<Object> shortTitle) {
        this.shortTitle = shortTitle;
    }

    @JsonProperty("issued")
    public Issued getIssued() {
        return issued;
    }

    @JsonProperty("issued")
    public void setIssued(Issued issued) {
        this.issued = issued;
    }

    @JsonProperty("references-count")
    public Integer getReferencesCount() {
        return referencesCount;
    }

    @JsonProperty("references-count")
    public void setReferencesCount(Integer referencesCount) {
        this.referencesCount = referencesCount;
    }

    @JsonProperty("alternative-id")
    public List<String> getAlternativeId() {
        return alternativeId;
    }

    @JsonProperty("alternative-id")
    public void setAlternativeId(List<String> alternativeId) {
        this.alternativeId = alternativeId;
    }

    @JsonProperty("URL")
    public String getURL() {
        return uRL;
    }

    @JsonProperty("URL")
    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    @JsonProperty("ISSN")
    public List<String> getISSN() {
        return iSSN;
    }

    @JsonProperty("ISSN")
    public void setISSN(List<String> iSSN) {
        this.iSSN = iSSN;
    }

    @JsonProperty("issn-type")
    public List<IssnType> getIssnType() {
        return issnType;
    }

    @JsonProperty("issn-type")
    public void setIssnType(List<IssnType> issnType) {
        this.issnType = issnType;
    }

    @JsonProperty("subject")
    public List<String> getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    @JsonProperty("published-online")
    public PublishedOnline getPublishedOnline() {
        return publishedOnline;
    }

    @JsonProperty("published-online")
    public void setPublishedOnline(PublishedOnline publishedOnline) {
        this.publishedOnline = publishedOnline;
    }

    @JsonProperty("original-title")
    public List<String> getOriginalTitle() {
        return originalTitle;
    }

    @JsonProperty("original-title")
    public void setOriginalTitle(List<String> originalTitle) {
        this.originalTitle = originalTitle;
    }

    @JsonProperty("abstract")
    public String getAbstract() {
        return _abstract;
    }

    @JsonProperty("abstract")
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    @JsonProperty("reference")
    public List<Reference> getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(List<Reference> reference) {
        this.reference = reference;
    }

    @JsonProperty("relation")
    public Relation getRelation() {
        return relation;
    }

    @JsonProperty("relation")
    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    @JsonProperty("archive")
    public List<String> getArchive() {
        return archive;
    }

    @JsonProperty("archive")
    public void setArchive(List<String> archive) {
        this.archive = archive;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

}