package com.racloop.data.service;

import com.racloop.data.model.name.NameComponent;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class NameCache {

    private HashMap<String, NameComponent> allWordMap = new HashMap<>();

    public int size() {
        return allWordMap.size();
    }

    public HashMap<String, NameComponent> getAllWordMap() {
        return allWordMap;
    }

    public NameComponent get(String word) {
        return allWordMap.get(word);
    }

    public void clear() {
        allWordMap.clear();
    }
}
