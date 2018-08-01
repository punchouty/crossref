package com.racloop.data.controller;


import com.racloop.data.repositories.mongodb.MongoDbNameComponentRepository;
import com.racloop.data.service.NameCache;
import com.racloop.data.service.mongodb.NameHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private NameHandler nameHandler;

    @Autowired
    private NameCache nameCache;

    @Autowired
    private MongoDbNameComponentRepository mongoDbNameComponentRepository;

    @GetMapping("/populate/{start}/{iterations}/{pageSize}")
    public Map<String, String> get(@PathVariable int start, @PathVariable int iterations, @PathVariable int pageSize){
        HashMap<String, String> returnMap = new HashMap<>();
        returnMap.put("status", "working");
        returnMap.put("get ", "" + new Date());
        nameHandler.asyncNamePopulation(start, iterations, pageSize);
        return returnMap;
    }

    @GetMapping("/word/{word}")
    public Map<String, Object> get(@PathVariable String word){
        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("input", word);
        returnMap.put("value", nameCache.get(word));
        return returnMap;
    }

    @GetMapping("/clear")
    public Map<String, String> clear(){
        HashMap<String, String> returnMap = new HashMap<>();
        nameCache.clear();
        returnMap.put("size", nameCache.size() + "");
        return returnMap;
    }

    @GetMapping("/size")
    public Map<String, String> size(){
        HashMap<String, String> returnMap = new HashMap<>();
        returnMap.put("size", nameCache.size() + "");
        return returnMap;
    }

    @GetMapping("/sizeDb")
    public Map<String, String> sizeDb(){
        HashMap<String, String> returnMap = new HashMap<>();
        returnMap.put("size", mongoDbNameComponentRepository.count() + "");
        return returnMap;
    }

    @GetMapping("/save")
    public Map<String, String> save(){
        HashMap<String, String> returnMap = new HashMap<>();
        returnMap.put("scheduled", "true");
        nameHandler.save();
        return returnMap;
    }

    @GetMapping("/saveFile")
    public Map<String, String> saveFile(){
        HashMap<String, String> returnMap = new HashMap<>();
        returnMap.put("scheduled", "true");
        nameHandler.saveFile();
        return returnMap;
    }

    @GetMapping("/stop")
    public Map<String, String> stop(){
        HashMap<String, String> returnMap = new HashMap<>();
        returnMap.put("scheduled", "true");
        nameHandler.stop();
        return returnMap;
    }

}
