package com.racloop.data.model.name;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "names")
public class NameComponent {

    @Id
    private String id;
    @Indexed
    private String word;
    @Indexed
    private String wordLowerCase;
    @Indexed
    private int familyNameOccurrencesCount;
    @Indexed
    private int givenNameOccurrenceCount;
    private int familyNameIndexZeroOccurrencesCount;
    private int familyNameIndexOneOccurrencesCount;
    private int familyNameIndexTwoOccurrencesCount;
    private int familyNameIndexThreeOccurrencesCount;
    private int givenNameIndexZeroOccurrencesCount;
    private int givenNameIndexOneOccurrencesCount;
    private int givenNameIndexTwoOccurrencesCount;
    private int givenNameIndexThreeOccurrencesCount;

    private int familyNameOccurrencesInOneTokenName;
    private int givenNameOccurrencesInOneTokenName;
    private int familyNameOccurrencesInTwoTokenName;
    private int givenNameOccurrencesInTwoTokenName;
    private int familyNameOccurrencesInThreeTokenName;
    private int givenNameOccurrencesInThreeTokenName;
    private int familyNameOccurrencesInFourTokenName;
    private int givenNameOccurrencesInFourTokenName;
    private int familyNameOccurrencesInFiveTokenName;
    private int givenNameOccurrencesInFiveTokenName;

    public String getCsvRecord() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(word + ",");
        stringBuilder.append(wordLowerCase + ",");
        stringBuilder.append(familyNameOccurrencesCount + ",");
        stringBuilder.append(givenNameOccurrenceCount + ",");
        stringBuilder.append(familyNameIndexZeroOccurrencesCount + ",");
        stringBuilder.append(familyNameIndexOneOccurrencesCount + ",");
        stringBuilder.append(familyNameIndexTwoOccurrencesCount + ",");
        stringBuilder.append(familyNameIndexThreeOccurrencesCount + ",");
        stringBuilder.append(givenNameIndexZeroOccurrencesCount + ",");
        stringBuilder.append(givenNameIndexOneOccurrencesCount + ",");
        stringBuilder.append(givenNameIndexTwoOccurrencesCount + ",");
        stringBuilder.append(givenNameIndexThreeOccurrencesCount + ",");
        stringBuilder.append(familyNameOccurrencesInOneTokenName + ",");
        stringBuilder.append(givenNameOccurrencesInOneTokenName + ",");
        stringBuilder.append(familyNameOccurrencesInTwoTokenName + ",");
        stringBuilder.append(givenNameOccurrencesInTwoTokenName + ",");
        stringBuilder.append(familyNameOccurrencesInThreeTokenName + ",");
        stringBuilder.append(givenNameOccurrencesInThreeTokenName + ",");
        stringBuilder.append(familyNameOccurrencesInFourTokenName + ",");
        stringBuilder.append(givenNameOccurrencesInFourTokenName + ",");
        stringBuilder.append(familyNameOccurrencesInFiveTokenName + ",");
        stringBuilder.append(givenNameOccurrencesInFiveTokenName);
        return stringBuilder.toString();
    }

    public DBObject getMongoDbObject() {
        DBObject dbObject = new BasicDBObject();
        ObjectId objectId = ObjectId.get();
        dbObject.put("_id", objectId);
        dbObject.put("word", word);
        dbObject.put("wordLowerCase", wordLowerCase);
        dbObject.put("familyNameOccurrencesCount", familyNameOccurrencesCount);
        dbObject.put("givenNameOccurrenceCount", givenNameOccurrenceCount);
        dbObject.put("familyNameIndexZeroOccurrencesCount", familyNameIndexZeroOccurrencesCount);
        dbObject.put("familyNameIndexOneOccurrencesCount", familyNameIndexOneOccurrencesCount);
        dbObject.put("familyNameIndexTwoOccurrencesCount", familyNameIndexTwoOccurrencesCount);
        dbObject.put("familyNameIndexThreeOccurrencesCount", familyNameIndexThreeOccurrencesCount);
        dbObject.put("givenNameIndexZeroOccurrencesCount", givenNameIndexZeroOccurrencesCount);
        dbObject.put("givenNameIndexOneOccurrencesCount", givenNameIndexOneOccurrencesCount);
        dbObject.put("givenNameIndexTwoOccurrencesCount", givenNameIndexTwoOccurrencesCount);
        dbObject.put("givenNameIndexThreeOccurrencesCount", givenNameIndexThreeOccurrencesCount);
        dbObject.put("familyNameOccurrencesInOneTokenName", familyNameOccurrencesInOneTokenName);
        dbObject.put("givenNameOccurrencesInOneTokenName", givenNameOccurrencesInOneTokenName);
        dbObject.put("familyNameOccurrencesInTwoTokenName", familyNameOccurrencesInTwoTokenName);
        dbObject.put("givenNameOccurrencesInTwoTokenName", givenNameOccurrencesInTwoTokenName);
        dbObject.put("familyNameOccurrencesInThreeTokenName", familyNameOccurrencesInThreeTokenName);
        dbObject.put("givenNameOccurrencesInThreeTokenName", givenNameOccurrencesInThreeTokenName);
        dbObject.put("familyNameOccurrencesInFourTokenName", familyNameOccurrencesInFourTokenName);
        dbObject.put("givenNameOccurrencesInFourTokenName", givenNameOccurrencesInFourTokenName);
        dbObject.put("familyNameOccurrencesInFiveTokenName", familyNameOccurrencesInFiveTokenName);
        dbObject.put("givenNameOccurrencesInFiveTokenName", givenNameOccurrencesInFiveTokenName);
        return dbObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameComponent that = (NameComponent) o;

        return word.equals(that.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordLowerCase() {
        return wordLowerCase;
    }

    public void setWordLowerCase(String wordLowerCase) {
        this.wordLowerCase = wordLowerCase;
    }

    public int getFamilyNameOccurrencesCount() {
        return familyNameOccurrencesCount;
    }

    public void setFamilyNameOccurrencesCount(int familyNameOccurrencesCount) {
        this.familyNameOccurrencesCount = familyNameOccurrencesCount;
    }

    public int getGivenNameOccurrenceCount() {
        return givenNameOccurrenceCount;
    }

    public void setGivenNameOccurrenceCount(int givenNameOccurrenceCount) {
        this.givenNameOccurrenceCount = givenNameOccurrenceCount;
    }

    public int getFamilyNameIndexZeroOccurrencesCount() {
        return familyNameIndexZeroOccurrencesCount;
    }

    public void setFamilyNameIndexZeroOccurrencesCount(int familyNameIndexZeroOccurrencesCount) {
        this.familyNameIndexZeroOccurrencesCount = familyNameIndexZeroOccurrencesCount;
    }

    public int getFamilyNameIndexOneOccurrencesCount() {
        return familyNameIndexOneOccurrencesCount;
    }

    public void setFamilyNameIndexOneOccurrencesCount(int familyNameIndexOneOccurrencesCount) {
        this.familyNameIndexOneOccurrencesCount = familyNameIndexOneOccurrencesCount;
    }

    public int getFamilyNameIndexTwoOccurrencesCount() {
        return familyNameIndexTwoOccurrencesCount;
    }

    public void setFamilyNameIndexTwoOccurrencesCount(int familyNameIndexTwoOccurrencesCount) {
        this.familyNameIndexTwoOccurrencesCount = familyNameIndexTwoOccurrencesCount;
    }

    public int getFamilyNameIndexThreeOccurrencesCount() {
        return familyNameIndexThreeOccurrencesCount;
    }

    public void setFamilyNameIndexThreeOccurrencesCount(int familyNameIndexThreeOccurrencesCount) {
        this.familyNameIndexThreeOccurrencesCount = familyNameIndexThreeOccurrencesCount;
    }

    public int getGivenNameIndexZeroOccurrencesCount() {
        return givenNameIndexZeroOccurrencesCount;
    }

    public void setGivenNameIndexZeroOccurrencesCount(int givenNameIndexZeroOccurrencesCount) {
        this.givenNameIndexZeroOccurrencesCount = givenNameIndexZeroOccurrencesCount;
    }

    public int getGivenNameIndexOneOccurrencesCount() {
        return givenNameIndexOneOccurrencesCount;
    }

    public void setGivenNameIndexOneOccurrencesCount(int givenNameIndexOneOccurrencesCount) {
        this.givenNameIndexOneOccurrencesCount = givenNameIndexOneOccurrencesCount;
    }

    public int getGivenNameIndexTwoOccurrencesCount() {
        return givenNameIndexTwoOccurrencesCount;
    }

    public void setGivenNameIndexTwoOccurrencesCount(int givenNameIndexTwoOccurrencesCount) {
        this.givenNameIndexTwoOccurrencesCount = givenNameIndexTwoOccurrencesCount;
    }

    public int getGivenNameIndexThreeOccurrencesCount() {
        return givenNameIndexThreeOccurrencesCount;
    }

    public void setGivenNameIndexThreeOccurrencesCount(int givenNameIndexThreeOccurrencesCount) {
        this.givenNameIndexThreeOccurrencesCount = givenNameIndexThreeOccurrencesCount;
    }

    public int getFamilyNameOccurrencesInOneTokenName() {
        return familyNameOccurrencesInOneTokenName;
    }

    public void setFamilyNameOccurrencesInOneTokenName(int familyNameOccurrencesInOneTokenName) {
        this.familyNameOccurrencesInOneTokenName = familyNameOccurrencesInOneTokenName;
    }

    public int getGivenNameOccurrencesInOneTokenName() {
        return givenNameOccurrencesInOneTokenName;
    }

    public void setGivenNameOccurrencesInOneTokenName(int givenNameOccurrencesInOneTokenName) {
        this.givenNameOccurrencesInOneTokenName = givenNameOccurrencesInOneTokenName;
    }

    public int getFamilyNameOccurrencesInTwoTokenName() {
        return familyNameOccurrencesInTwoTokenName;
    }

    public void setFamilyNameOccurrencesInTwoTokenName(int familyNameOccurrencesInTwoTokenName) {
        this.familyNameOccurrencesInTwoTokenName = familyNameOccurrencesInTwoTokenName;
    }

    public int getGivenNameOccurrencesInTwoTokenName() {
        return givenNameOccurrencesInTwoTokenName;
    }

    public void setGivenNameOccurrencesInTwoTokenName(int givenNameOccurrencesInTwoTokenName) {
        this.givenNameOccurrencesInTwoTokenName = givenNameOccurrencesInTwoTokenName;
    }

    public int getFamilyNameOccurrencesInThreeTokenName() {
        return familyNameOccurrencesInThreeTokenName;
    }

    public void setFamilyNameOccurrencesInThreeTokenName(int familyNameOccurrencesInThreeTokenName) {
        this.familyNameOccurrencesInThreeTokenName = familyNameOccurrencesInThreeTokenName;
    }

    public int getGivenNameOccurrencesInThreeTokenName() {
        return givenNameOccurrencesInThreeTokenName;
    }

    public void setGivenNameOccurrencesInThreeTokenName(int givenNameOccurrencesInThreeTokenName) {
        this.givenNameOccurrencesInThreeTokenName = givenNameOccurrencesInThreeTokenName;
    }

    public int getFamilyNameOccurrencesInFourTokenName() {
        return familyNameOccurrencesInFourTokenName;
    }

    public void setFamilyNameOccurrencesInFourTokenName(int familyNameOccurrencesInFourTokenName) {
        this.familyNameOccurrencesInFourTokenName = familyNameOccurrencesInFourTokenName;
    }

    public int getGivenNameOccurrencesInFourTokenName() {
        return givenNameOccurrencesInFourTokenName;
    }

    public void setGivenNameOccurrencesInFourTokenName(int givenNameOccurrencesInFourTokenName) {
        this.givenNameOccurrencesInFourTokenName = givenNameOccurrencesInFourTokenName;
    }

    public int getFamilyNameOccurrencesInFiveTokenName() {
        return familyNameOccurrencesInFiveTokenName;
    }

    public void setFamilyNameOccurrencesInFiveTokenName(int familyNameOccurrencesInFiveTokenName) {
        this.familyNameOccurrencesInFiveTokenName = familyNameOccurrencesInFiveTokenName;
    }

    public int getGivenNameOccurrencesInFiveTokenName() {
        return givenNameOccurrencesInFiveTokenName;
    }

    public void setGivenNameOccurrencesInFiveTokenName(int givenNameOccurrencesInFiveTokenName) {
        this.givenNameOccurrencesInFiveTokenName = givenNameOccurrencesInFiveTokenName;
    }
}
