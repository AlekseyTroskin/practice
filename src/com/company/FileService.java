package com.company;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileService {


    public static HashMap<String, String> convertHashMap(String pathFileStr) throws IOException {

        File file = new File(pathFileStr);
        if (file.createNewFile()){
            System.out.println("Словарь создан!");
        }
        else{
            System.out.println("Словарь уже существует!");
        }

        HashMap<String, String> dictionary = new HashMap<>();
        Scanner filescan = new Scanner(new FileReader(pathFileStr));
        while (filescan.hasNext()) {
            String[] columns = filescan.nextLine().split(":");
            dictionary.put(columns[0], columns[1]);
        }
        filescan.close();
        return dictionary;
    }

    public static void writeTxt(HashMap<String, String> stringListHashMap, String pathFileStr) throws IOException{

        Files.write(Paths.get(pathFileStr),
                stringListHashMap.entrySet().stream().map(k->k.getKey()+":"+k.getValue()).collect(Collectors.toList()),
                StandardCharsets.UTF_8);

        Files.lines(Paths.get(pathFileStr), StandardCharsets.UTF_8).forEach(System.out::println);
    }
}
