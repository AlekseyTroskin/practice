package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;


public class Menu{


    public static Scanner in = new Scanner(System.in);


    public static void select() throws IOException{
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
                case 1:
                    String PATH = "src/resources/File1.txt";
                    action(PATH);
                    break;
                case 2:
                    PATH = "src/resources/File2.txt";
                    action(PATH);
                    break;
                case 3:
                    System.exit(0);
            }
        }


    }


public static void action(String PATH) throws IOException {

    File.convertHashMap(PATH);

    int method = 0;
    String choice ="";
    String limit = "5";


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
                File.FileRead();
                break;
            case 2:
                // вызов метода 2
                File.Delete();
                break;
            case 3:
                // вызов метода 3
                System.out.print("Введите слово для поиска: ");

                File.Search();
                break;
            case 4:
                // вызов метода 4
                File.AddFile();
                break;
            case 5:
                File.writeHashMap();
                select();
        }
    }
        System.out.println("До свидания!");

}
}

