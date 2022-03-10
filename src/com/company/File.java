package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class File {

    public static HashMap<Object, String> dictionary = new HashMap<>();
    public static Scanner in = new Scanner(System.in);
    private static String pathFile;

    public static void convertHashMap(String PATH) throws IOException {
        pathFile = PATH;
        Scanner filescan = new Scanner(new FileReader(File.pathFile));
        while (filescan.hasNextLine()) {
            String[] columns = filescan.nextLine().split(":");
            dictionary.put(columns[0], columns[1]);
        }
    }

    public static void writeTxt() throws IOException{
        Files.write(Paths.get(pathFile),
                dictionary.entrySet().stream().map(k->k.getKey()+":"+k.getValue()).collect(Collectors.toList()),
                StandardCharsets.UTF_8);

        Files.lines(Paths.get(pathFile), StandardCharsets.UTF_8).forEach(System.out::println);

        dictionary.clear();
    }

    public static void FileRead() {
                for (HashMap.Entry entry : dictionary.entrySet()) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
    }

    public static void AddFile(){
        System.out.println("Введите ключ: ");
        String key = in.nextLine();
        int i = 0;
        i = Integer.parseInt(key);
        if (i > 0){
            System.out.println("Введите значение: ");
            String value = in.nextLine();
            dictionary.put(key,value);
        }
        else {
            System.out.println("Неправильный ключ!");
        }

    }

    public static void Search() {
        String key = in.nextLine();
        String searchWord = dictionary.get(key);
        if (searchWord != null) {
            System.out.println(searchWord);
        }
        else {
            System.out.println("Значения с таким ключом не найдено!");
        }
    }


    public static void Delete() {
        System.out.print("Введите ключ значения,которое хотите удалить: ");
        String keyDel = in.nextLine();
        String keySearch = dictionary.get(keyDel);
        if (keySearch != null){
            dictionary.remove(keyDel);
        }
        else {
            System.out.println("Значения с таким ключом не найдено!");
        }
    }
}
