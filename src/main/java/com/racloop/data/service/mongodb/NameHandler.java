package com.racloop.data.service.mongodb;

import com.mongodb.BulkWriteOperation;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.racloop.data.model.mongodb.Author;
import com.racloop.data.model.mongodb.Work;
import com.racloop.data.model.name.NameComponent;
import com.racloop.data.repositories.mongodb.MongoDbNameComponentRepository;
import com.racloop.data.repositories.mongodb.MongoDbWorkRepository;
import com.racloop.data.service.CrossRefClient;
import com.racloop.data.service.NameCache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Service
public class NameHandler {

    public static final String FILE_NAME = "/Volumes/Seagate/name.csv";
    @Autowired
    private MongoDbWorkRepository mongoDbWorkRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoDbNameComponentRepository mongoDbNameComponentRepository;

    @Autowired
    private CrossRefClient crossRefClient;

    @Autowired
    private NameCache nameCache;

    private boolean stop = false;

    public void stop() {
        stop = true;
    }

    @Async
    public void asyncNamePopulation(int start, int iterations, int pageSize) {
        long timeStart = System.currentTimeMillis();
        HashMap<String, NameComponent> allWordMap = nameCache.getAllWordMap();
        for (int i = start; i < iterations; i++) {
            if(stop) {
                stop = false;
                break;
            }
            long timeCurrent = System.currentTimeMillis();
            long timePassed = (timeCurrent - timeStart)/ (1000 * 60);
            System.out.println(new Date() + ", Iteration : " + i + ", size : " + nameCache.size() + ", timePassed (minutes) :" + timePassed);
            PageRequest pageRequest = PageRequest.of(i, pageSize);
            Page<Work> page = mongoDbWorkRepository.findAll(pageRequest);
            for (Work work : page.getContent()) {
                HashMap<String, NameComponent> wordNameMap = process(work);
                merge(allWordMap, wordNameMap);
            }
        }
    }

    public HashMap<String, NameComponent> process(Work work) {
        HashMap<String, NameComponent> allWordMap = new HashMap<>();
        List<Author> authors = work.getAuthor();
        for (Author author : authors) {
            HashMap<String, NameComponent> singleNameMap = processAuthor(author.getFamily(), author.getGiven());
            merge(allWordMap, singleNameMap);
        }
        return allWordMap;
    }

    private HashMap<String, NameComponent> processAuthor(String familyName, String givenName) {
        HashMap<String, NameComponent> wordMap = new HashMap<>();
        int tokenCount = countTokens(familyName, givenName);
        int index = 0;
        if(!StringUtils.isBlank(familyName) && familyName.indexOf('\uFFFD') < 0 && familyName.indexOf('?') < 0) {
            HashMap<String, NameComponent> map = new HashMap<>();
            String[] familyNameTokens = familyName.split(" ");
            for (String familyNameToken : familyNameTokens) {
                if (familyNameToken.indexOf('.') > 0) {
                    //ignore R. etc
                } else if (familyNameToken.length() == 1) {
                    //ignore R etc
                } else {
                    NameComponent nameComponent = new NameComponent();
                    nameComponent.setWord(familyNameToken);
                    nameComponent.setWordLowerCase(normalize(familyNameToken));
                    nameComponent.setFamilyNameOccurrencesCount(1);
                    if (index == 0) {
                        nameComponent.setFamilyNameIndexZeroOccurrencesCount(1);
                    } else if (index == 1) {
                        nameComponent.setFamilyNameIndexOneOccurrencesCount(1);
                    } else if (index == 2) {
                        nameComponent.setFamilyNameIndexTwoOccurrencesCount(1);
                    } else {
                        nameComponent.setFamilyNameIndexThreeOccurrencesCount(1);
                    }
                    map.put(familyNameToken, nameComponent);
                }
                index++;
            }
            if(tokenCount == 1) {
                for (NameComponent familyNameComponent : map.values()) {
                    familyNameComponent.setFamilyNameOccurrencesInOneTokenName(1);
                }
            }
            else if(tokenCount == 2) {
                for (NameComponent familyNameComponent : map.values()) {
                    familyNameComponent.setFamilyNameOccurrencesInTwoTokenName(1);
                }
            }
            else if(tokenCount == 3) {
                for (NameComponent familyNameComponent : map.values()) {
                    familyNameComponent.setFamilyNameOccurrencesInThreeTokenName(1);
                }
            }
            else if(tokenCount == 4) {
                for (NameComponent familyNameComponent : map.values()) {
                    familyNameComponent.setFamilyNameOccurrencesInFourTokenName(1);
                }
            }
            else if(tokenCount == 5) {
                for (NameComponent familyNameComponent : map.values()) {
                    familyNameComponent.setFamilyNameOccurrencesInFiveTokenName(1);
                }
            }
            wordMap.putAll(map);
        }
        index = 0;
        if(!StringUtils.isBlank(givenName) && givenName.indexOf('\uFFFD') < 0 && givenName.indexOf('?') < 0) {
            HashMap<String, NameComponent> map = new HashMap<>();
            String [] givenNameTokens = givenName.split(" ");
            for (String givenNameToken : givenNameTokens) {
                if (givenNameToken.indexOf('.') > 0) {
                    //ignore R. etc
                } else if (givenNameToken.length() == 1) {
                    //ignore R etc
                } else {
                    NameComponent nameComponent = new NameComponent();
                    nameComponent.setWord(givenNameToken);
                    nameComponent.setWordLowerCase(normalize(givenNameToken));
                    nameComponent.setGivenNameOccurrenceCount(1);
                    if (index == 0) {
                        nameComponent.setGivenNameIndexZeroOccurrencesCount(1);
                    } else if (index == 1) {
                        nameComponent.setGivenNameIndexOneOccurrencesCount(1);
                    } else if (index == 2) {
                        nameComponent.setGivenNameIndexTwoOccurrencesCount(1);
                    } else {
                        nameComponent.setGivenNameIndexThreeOccurrencesCount(1);
                    }
                    map.put(givenNameToken, nameComponent);
                }
                index++;
            }
            if(tokenCount == 1) {
                for (NameComponent givenNameComponent : map.values()) {
                    givenNameComponent.setGivenNameOccurrencesInOneTokenName(1);
                }
            }
            else if(tokenCount == 2) {
                for (NameComponent givenNameComponent : map.values()) {
                    givenNameComponent.setGivenNameOccurrencesInTwoTokenName(1);
                }
            }
            else if(tokenCount == 3) {
                for (NameComponent givenNameComponent : map.values()) {
                    givenNameComponent.setGivenNameOccurrencesInThreeTokenName(1);
                }
            }
            else if(tokenCount == 4) {
                for (NameComponent givenNameComponent : map.values()) {
                    givenNameComponent.setGivenNameOccurrencesInFourTokenName(1);
                }
            }
            else if(tokenCount == 5) {
                for (NameComponent givenNameComponent : map.values()) {
                    givenNameComponent.setGivenNameOccurrencesInFiveTokenName(1);
                }
            }
            wordMap.putAll(map);
        }
        return wordMap;
    }

//    @Async
//    public void save() {
//        int index = 0;
//        BulkOperations bulkOperations = null;
//        for (NameComponent nameComponent : nameCache.getAllWordMap().values()) {
//            if(index == 0) {
//                bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, NameComponent.class);
//                bulkOperations.insert(nameComponent);
//            }
//            else if(index == 1000) {
//                bulkOperations.execute();
//                index = 0;
//            }
//            else {
//                bulkOperations.insert(nameComponent);
//            }
//            index++;
//        }
//    }

    @Async
    public void save() {
        MongoClient mongoClient = new MongoClient("localhost");
        DB db = mongoClient.getDB("crossref");
        DBCollection dbCollection = db.getCollection("names");
        BulkWriteOperation bulkWriteOperation = dbCollection.initializeUnorderedBulkOperation();
        int index = 0;
        Collection<NameComponent> collection = Collections.unmodifiableCollection(nameCache.getAllWordMap().values());
        for (NameComponent nameComponent : collection) {
            bulkWriteOperation.insert(nameComponent.getMongoDbObject());
            if(index == 500) {
                bulkWriteOperation.execute();
                index = 0;
                if(stop) {
                    stop = false;
                    break;
                }
                bulkWriteOperation = dbCollection.initializeUnorderedBulkOperation();
            }
            index++;
        }
    }

    @Async
    public void saveFile() {
        File newFile = new File(FILE_NAME);
        FileWriter fw = null;
        try {
            fw = new FileWriter(newFile, true);
            BufferedWriter writer = new BufferedWriter(fw);
            for (NameComponent nameComponent : nameCache.getAllWordMap().values()) {
                writer.write(nameComponent.getCsvRecord() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String normalize(String input) {
        String output = input.toLowerCase();
        output = output.replaceAll("[^\\p{L}^\\p{Pd}]", "");
        return output;
    }

    private int countTokens(String familyName, String giveName) {
        int count = 0;
        if(!StringUtils.isBlank(familyName)) {
            String[] str = familyName.split(" ");
            for (String s : str) {
                String[] t = s.split("\\.");
                count = count + t.length;
            }
        }
        if(!StringUtils.isBlank(giveName)) {
            String[] str = giveName.split(" ");
            for (String s : str) {
                String[] t = s.split("\\.");
                count = count + t.length;
            }
        }
        return count;
    }

    private void merge(HashMap<String, NameComponent> parentMap, HashMap<String, NameComponent> childMap) {
        for (String key : childMap.keySet()) {
            NameComponent child = childMap.get(key);
            NameComponent parent = parentMap.get(key);
            if(parent == null) {
                parentMap.put(key, child);
            }
            else {
                merge(parent, child);
            }
        }
    }

    private void merge(NameComponent parent, NameComponent child) {
        parent.setGivenNameOccurrenceCount(parent.getGivenNameOccurrenceCount() + child.getGivenNameOccurrenceCount());
        parent.setFamilyNameOccurrencesCount(parent.getFamilyNameOccurrencesCount() + child.getFamilyNameOccurrencesCount());
        parent.setFamilyNameIndexZeroOccurrencesCount(parent.getFamilyNameIndexZeroOccurrencesCount() + child.getFamilyNameIndexZeroOccurrencesCount());
        parent.setFamilyNameIndexOneOccurrencesCount(parent.getFamilyNameIndexOneOccurrencesCount() + child.getFamilyNameIndexOneOccurrencesCount());
        parent.setFamilyNameIndexTwoOccurrencesCount(parent.getFamilyNameIndexTwoOccurrencesCount() + child.getFamilyNameIndexTwoOccurrencesCount());
        parent.setFamilyNameIndexThreeOccurrencesCount(parent.getFamilyNameIndexThreeOccurrencesCount() + child.getFamilyNameIndexThreeOccurrencesCount());
        parent.setGivenNameIndexZeroOccurrencesCount(parent.getGivenNameIndexZeroOccurrencesCount() + child.getGivenNameIndexZeroOccurrencesCount());
        parent.setGivenNameIndexOneOccurrencesCount(parent.getGivenNameIndexOneOccurrencesCount() + child.getGivenNameIndexOneOccurrencesCount());
        parent.setGivenNameIndexTwoOccurrencesCount(parent.getGivenNameIndexTwoOccurrencesCount() + child.getGivenNameIndexTwoOccurrencesCount());
        parent.setGivenNameIndexThreeOccurrencesCount(parent.getGivenNameIndexThreeOccurrencesCount() + child.getGivenNameIndexThreeOccurrencesCount());


        parent.setFamilyNameOccurrencesInOneTokenName(parent.getFamilyNameOccurrencesInOneTokenName() + child.getFamilyNameOccurrencesInOneTokenName());
        parent.setFamilyNameOccurrencesInTwoTokenName(parent.getFamilyNameOccurrencesInTwoTokenName() + child.getFamilyNameOccurrencesInTwoTokenName());
        parent.setFamilyNameOccurrencesInThreeTokenName(parent.getFamilyNameOccurrencesInThreeTokenName() + child.getFamilyNameOccurrencesInThreeTokenName());
        parent.setFamilyNameOccurrencesInFourTokenName(parent.getFamilyNameOccurrencesInFourTokenName() + child.getFamilyNameOccurrencesInFourTokenName());
        parent.setFamilyNameOccurrencesInFiveTokenName(parent.getFamilyNameOccurrencesInFiveTokenName() + child.getFamilyNameOccurrencesInFiveTokenName());

        parent.setGivenNameOccurrencesInOneTokenName(parent.getGivenNameOccurrencesInOneTokenName() + child.getGivenNameOccurrencesInOneTokenName());
        parent.setGivenNameOccurrencesInTwoTokenName(parent.getGivenNameOccurrencesInTwoTokenName() + child.getGivenNameOccurrencesInTwoTokenName());
        parent.setGivenNameOccurrencesInThreeTokenName(parent.getGivenNameOccurrencesInThreeTokenName() + child.getGivenNameOccurrencesInThreeTokenName());
        parent.setGivenNameOccurrencesInFourTokenName(parent.getGivenNameOccurrencesInFourTokenName() + child.getGivenNameOccurrencesInFourTokenName());
        parent.setGivenNameOccurrencesInFiveTokenName(parent.getGivenNameOccurrencesInFiveTokenName() + child.getGivenNameOccurrencesInFiveTokenName());
    }

}
