package com.company;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;



public class Menu{



public static void action() throws IOException {
    Scanner scan = new Scanner(System.in);
    int method = 0;
    String choice ="";
    String limit = "5";


        while (!Objects.equals(limit, choice)){
        System.out.println("1. Для просмотра содержимого словарей введите 1");
        System.out.println("2. Для удаления записи в словаре введите 2");
        System.out.println("3. Для поиска записи по ключу в словаре введите 3");
        System.out.println("4. Для добавления записи в словарь введите 4");
        System.out.println("5. Для выхода из приложения введите 5");
        choice = scan.next();

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
                File.Search();
                break;
            case 4:
                // вызов метода 4
                File.AddFile();
                break;
            case 5:
                System.exit(0);
        }
    }
        System.out.println("До свидания!");

}
}

