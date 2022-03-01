package com.company;

import java.util.Objects;
import java.util.Scanner;



public class Menu<s> {

public static void action() {
    Scanner scan = new Scanner(System.in);
    int x = 0;
    String s ="";
    int k = 5;

    System.out.println("");

        while (!Objects.equals(k, s)){
        System.out.println("1. Для просмотра содержимого словарей введите 1");
        System.out.println("2. Для удаления записи в словаре введите 2");
        System.out.println("3. Для поиска записи по ключу в словаре введите 3");
        System.out.println("3. Для добавления записи в словарь введите 4");
        System.out.println("5. Для выхода из приложения введите 5");
        s = scan.next();

        try {
            x = Integer.parseInt(s);
        } catch (NumberFormatException e){
            System.out.println("Неверный ввод");
        }

        switch (x){
            case 1:
                // вызов метода 1
                System.out.println("Первое действие");
                break;
            case 2:
                // вызов метода 2
                break;
            case 3:
                // вызов метода 3
                break;
            case 4:
                // вызов метода 4
                break;
            case 5:
                System.exit(0);
        }
    }
        System.out.println("До свидания!");

}
}

