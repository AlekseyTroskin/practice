package com.company;

import java.io.IOException;
import java.util.*;


public class Menu{


    public static Scanner in = new Scanner(System.in);
    public static String select;
    public static String choice;
    public static String key;
    public static String value;
    public static String searchWord;


    private static DictionaryInt dictionaryInt;


    public static void select() throws IOException{
        System.out.println("Выберите словарь");
        select = "";
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
                case 1:
                    dictionaryInt = new Dictionary();
                    dictionaryInt.setFile("src/resources/File1.txt");
                    dictionaryInt.setRegFile("[A-z]{4}");
                    FileService.convertHashMap();
                    action();
                    break;
                case 2:
                    dictionaryInt = new Dictionary();
                    dictionaryInt.setFile("src/resources/File2.txt");
                    dictionaryInt.setRegFile("\\d{5}");
                    FileService.convertHashMap();
                    action();
                    break;
                case 3:
                    System.out.println("До свидания!");
                    System.exit(0);
            }
        }


    }


public static void action() throws IOException {


    int method = 0;
    String limit = "5";
    choice = "";


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

        switch (method){
            case 1:
                // вызов метода просмотра словарей
                HashMap<String, String> stringListHashMap = dictionaryInt.input();
                for (HashMap.Entry entry : stringListHashMap.entrySet()) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
                break;
            case 2:
                // вызов метода для удаления записи в словаре
                System.out.print("Введите ключ значения,которое хотите удалить: ");
                key = in.nextLine();
                dictionaryInt.remove(key);
                break;
            case 3:
                // вызов метода для поиска записи по ключу
                System.out.print("Введите ключ для поиска записи: ");
                key = in.nextLine();
                dictionaryInt.search(key);
                break;
            case 4:
                // вызов метода для добавления записи в словарь
                System.out.println("Введите ключ: ");
                key = in.nextLine();
                System.in.read();
                System.out.println("Введите значение: ");
                value = in.nextLine();

                dictionaryInt.add();
                break;
            case 5:
                //Запись из HashMap в txt
                FileService.writeTxt();
                select();
        }
    }
}
}

