package com.racloop.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

    public static void main(String[] args) {
        String filePath = "/Volumes/Seagate/crossrefworks.json";
        BufferedReader fileReader = null;
        try {
            fileReader =
                    new BufferedReader(new FileReader(filePath));
            String line = fileReader.readLine();
            int index = 0;
            while (line != null) {
                index++;
                line = fileReader.readLine();
                if(line.contains("58d96fec0c62134f84023a29")) {
                    System.out.println(line);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
