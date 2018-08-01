package com.racloop.data.service;

import com.racloop.data.model.crossref.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class CrossRefClient {

    public static final String email = "rajan@datiot.com";
    public static final int MAX_RETRY = 4;

    public DoiResult getDoiResults(String doi, int retryCount) {
        retryCount++;
        if(retryCount == MAX_RETRY) {
            return null;
        }
        String url = "https://api.crossref.org/works/" + doi + "&mailto=" + email;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "data-analyser/0.1 (mailto:" + email + ") Data/0.1");

        ResponseEntity<DoiResult> response
                = restTemplate.getForEntity(url, DoiResult.class);
        if (response.getStatusCode() == HttpStatus.OK)
            return response.getBody();
        else
            return getDoiResults(doi, retryCount);
    }

    public SearchResults searchCrossRef(String titleAndJournal) throws UnsupportedEncodingException {
        titleAndJournal = URLEncoder.encode(titleAndJournal, "UTF-8");
        String url = "https://api.crossref.org/works?query=" + titleAndJournal + "&rows=10&mailto=" + email;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "unitouch-plus/1.0 (mailto:" + email + ") Unitouch/1.5");

        ResponseEntity<SearchResults> response = restTemplate.getForEntity(url, SearchResults.class);
        if (response.getStatusCode() == HttpStatus.OK)
            return response.getBody();
        else
            return null;
    }

    public SearchResults searchAuthor(String authorName) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(authorName)) {
            return null;
        }

        String url = "https://api.crossref.org/works?query.author=" + authorName;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<SearchResults> response = restTemplate.getForEntity(url, SearchResults.class);
        if (response.getStatusCode() == HttpStatus.OK)
            return response.getBody();
        else
            return null;
    }

    public HashSet<String> fetch(String query) throws UnsupportedEncodingException {
        HashSet<String> lines = new HashSet<>();
        query = URLEncoder.encode(query, "UTF-8");
        String cursor = "*";
        String url = null;
        int index = 0;
        while(cursor != null && (cursor.equals("*") || cursor.length() > 50)) {
            System.out.println("Request number : " + index++);
            url = "https://api.crossref.org/works?query.author=" + query + "&cursor=" + cursor + "&rows=1000&mailto=" + email;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("User-Agent", "app/1.1 (mailto:" + email + ") Express/1.1");

            try {
                ResponseEntity<SearchResults> response = restTemplate.getForEntity(url, SearchResults.class);
                if (response.getStatusCode() == HttpStatus.OK) {
                    System.out.println("Download size complete : " + index);
                    SearchResults searchResults = response.getBody();
                    if(searchResults.getSearchMessage().getItems().size() <= 0) {
                        break;
                    }
                    cursor = searchResults.getSearchMessage().getNextCursor();
                    HashSet<String> authors = parse(searchResults.getSearchMessage());
                    lines.addAll(authors);
                }
            } catch (RestClientException e) {
                e.printStackTrace();
            }
            System.out.println("Current Size : " + lines.size());
        }
        System.out.println(lines.size());
        return lines;
    }

    private HashSet<String> parse(SearchMessage searchMessage) {
        HashSet<String> lines = new HashSet<>();
        List<Item> items = searchMessage.getItems();
        for (Item item : items) {
            List<Author> authors = item.getAuthor();
            for (Author author : authors) {
                if(author.getName() != null) {
                    lines.add(author.getName());
                }
            }
        }
        return lines;
    }
}
