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
        //dictionary.clear();
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


   /* public static void fileRead() {
                for (var entry : dictionary.entrySet()) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
    }

    public static void addFile(String keyRegex1, String keyRegex2) throws IOException {
         String regex = "[А-я]+";
        if (d==1) {
            if(key.matches(keyRegex1)){
                if (value.matches(regex)){
                    dictionary.put(key,value);
                    System.out.println("Запись успешно добавлена!");
                }
                else {
                    System.out.println("Неверное значение!");
                }
            }
            else {
                System.out.println("Ключ неверный!");
            }
        }
        else {
            if(key.matches(keyRegex2)){
                if (value.matches(regex)){
                    dictionary.put(key,value);
                    System.out.println("Запись успешно добавлена!");
                }
                else System.out.println("Неверное значение!");
            }
            else {
                System.out.println("Ключ неверный!");
            }
        }
        writeTxt();
    }

    public static void search() {
        String key = in.nextLine();
        String searchWord = dictionary.get(key);
        if (searchWord != null) {
            System.out.println(searchWord);
        }
        else {
            System.out.println("Значения с таким ключом не найдено!");
        }
    }


    public static void delete() throws IOException {
        String keyDel = in.nextLine();
        String keySearch = dictionary.get(keyDel);
        if (keySearch != null){
            dictionary.remove(keyDel);
        }
        else {
            System.out.println("Значения с таким ключом не найдено!");
        }
        writeTxt();
    }*/
}
