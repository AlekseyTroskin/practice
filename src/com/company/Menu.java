package com.company;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Menu{



    public static String searchWord;
    private static DictionaryInt dictionaryInt;


    public static void select() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите словарь");
        String select = "";
        String lim = "3";
        int dictionary = 0;
        while (!Objects.equals(lim, select)) {
            System.out.println("1.Словарь со словами длиной 4 символа и эти символы только только буквы латинской раскладки");
            System.out.println("2.Словарь со словами длиной 5 символов и эти символы только цифры");
            System.out.println("3.Выход из приложения");
            select = in.next();
            try {
                dictionary = Integer.parseInt(select);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }

            switch (dictionary) {
                case 1 -> {
                    File file = new File("src/resources/File1.txt");
                    if (file.createNewFile()){
                        System.out.println("Словарь создан!");
                    }
                    else{
                        System.out.println("Словарь уже существует!");
                    }
                    dictionaryInt = new Dictionary();
                    dictionaryInt.setFile("src/resources/File1.txt");
                    dictionaryInt.setRegFile("[A-Za-z]{4}");
                    FileService.setPathToFile("src/resources/File1.txt");
                    FileService.convertHashMap();
                    action();
                }
                case 2 -> {
                    File file = new File("src/resources/File2.txt");
                    if (file.createNewFile()){
                        System.out.println("Словарь создан!");
                    }
                    else{
                        System.out.println("Словарь уже существует!");
                    }
                    dictionaryInt = new Dictionary();
                    dictionaryInt.setFile("src/resources/File2.txt");
                    dictionaryInt.setRegFile("\\d{5}");
                    FileService.setPathToFile("src/resources/File2.txt");
                    FileService.convertHashMap();
                    action();
                }
                case 3 -> {
                    System.out.println("До свидания!");
                    System.exit(0);
                }
            }
        }


    }


public static void action() throws IOException {

    Scanner in = new Scanner(System.in);
    Dictionary.dictionaryHashMap();
    int method = 0;
    String limit = "5";
    String choice = "";
    String key;
    String value;


        while (!Objects.equals(limit, choice)){
        System.out.println("1. Для просмотра содержимого словарей введите 1");
        System.out.println("2. Для удаления записи в словаре введите 2");
        System.out.println("3. Для поиска записи по ключу в словаре введите 3");
        System.out.println("4. Для добавления записи в словарь введите 4");
        System.out.println("5. Для возврата к выбору словаря введите 5");
        choice = in.next();

        try {
            method = Integer.parseInt(choice);
        } catch (NumberFormatException e){
            System.out.println("Неверный ввод");
        }

            switch (method) {
                case 1 -> {
                    // вызов метода просмотра словарей
                    HashMap<String, String> stringListHashMap = dictionaryInt.input();
                    for (HashMap.Entry entry : stringListHashMap.entrySet()) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                    }
                }
                case 2 -> {
                    // вызов метода для удаления записи в словаре
                    Scanner del = new Scanner(System.in);
                    System.out.print("Введите ключ значения,которое хотите удалить: ");
                    key = del.nextLine();
                    dictionaryInt.remove(key);
                }
                case 3 -> {
                    // вызов метода для поиска записи по ключу
                    Scanner searchKey = new Scanner(System.in);
                    System.out.print("Введите ключ для поиска записи: ");
                    key = searchKey.nextLine();
                    dictionaryInt.search(key);
                }
                case 4 -> {
                    // вызов метода для добавления записи в словарь
                    Scanner addKey = new Scanner(System.in);
                    Scanner addValue = new Scanner(System.in);
                    System.out.println("Введите ключ: ");
                    key = addKey.nextLine();
                    System.out.println("Введите значение: ");
                    value = addValue.nextLine();
                    dictionaryInt.add(key,value);
                }
                case 5 ->
                        //возврат к выбору словарей
                        select();
            }
    }
}

    public void setPathFile() {
    }
}

