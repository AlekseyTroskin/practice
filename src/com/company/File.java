package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.company.Menu.d;

public class File {

    public static HashMap<Object, String> dictionary = new HashMap<>();
    public static Scanner in = new Scanner(System.in);
    private static String pathFile;

    public static void convertHashMap(String PATH) throws IOException {
        dictionary.clear();
        pathFile = PATH;
        Scanner filescan = new Scanner(new FileReader(File.pathFile));
        while (filescan.hasNextLine()) {
            String[] columns = filescan.nextLine().split(":");
            dictionary.put(columns[0], columns[1]);
        }
        filescan.close();
    }

    public static void writeTxt() throws IOException{
        Files.write(Paths.get(pathFile),
                dictionary.entrySet().stream().map(k->k.getKey()+":"+k.getValue()).collect(Collectors.toList()),
                StandardCharsets.UTF_8);

        Files.lines(Paths.get(pathFile), StandardCharsets.UTF_8).forEach(System.out::println);
    }

    public static void FileRead() {
                for (HashMap.Entry entry : dictionary.entrySet()) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
    }

    public static void AddFile() throws IOException {
         String keyRegex1 = "[A-z]{4}";
         String keyRegex2 = "\\d{5}";
         String regex = "[А-я]+";
         String key = in.nextLine();
        if (d==1) {
            if(key.matches(keyRegex1)){
                System.out.println("Введите значение: ");
                String value = in.nextLine();
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
                System.out.println("Введите значение: ");
                String value = in.nextLine();
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


    public static void Delete() throws IOException {
        System.out.print("Введите ключ значения,которое хотите удалить: ");
        String keyDel = in.nextLine();
        String keySearch = dictionary.get(keyDel);
        if (keySearch != null){
            dictionary.remove(keyDel);
        }
        else {
            System.out.println("Значения с таким ключом не найдено!");
        }
        writeTxt();
    }
}
