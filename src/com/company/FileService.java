package com.company;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileService {


    private static String pathFiles;
    private static final Menu menu = new Menu();



    public static void setPathToFile(String pathToFile) {
        pathFiles = pathToFile;
        menu.setPathFile();
    }


    public static HashMap<String,String> convertHashMap() throws IOException {
        HashMap<String, String> dictionary = new HashMap<>();
        Scanner filescan = new Scanner(new FileReader(FileService.pathFiles));
        while (filescan.hasNextLine()) {
            String[] columns = filescan.nextLine().split(":");
            dictionary.put(columns[0], columns[1]);
        }
        filescan.close();
        return dictionary;
    }

    public static void writeTxt(HashMap<String, String> stringListHashMap) throws IOException{

        Files.write(Paths.get(pathFiles),
                stringListHashMap.entrySet().stream().map(k->k.getKey()+":"+k.getValue()).collect(Collectors.toList()),
                StandardCharsets.UTF_8);

        Files.lines(Paths.get(pathFiles), StandardCharsets.UTF_8).forEach(System.out::println);
    }

    public void setPathFile() {
    }
}
