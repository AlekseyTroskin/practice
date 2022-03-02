package com.company;

import java.io.*;
import java.util.Scanner;

public class File {

    public File(String s) {
    }

    public static void FileRead() throws IOException{
        try (BufferedReader in = new BufferedReader(new FileReader("dictionaries/File1.txt"))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void AddFile(){
        String filePath = "dictionaries/File1.txt";

        Scanner in = new Scanner(System.in);
        System.out.print("Введите данные: ");
        String text = in.nextLine();


        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println();
        }
    }

    public static void Search() throws FileNotFoundException, IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово для поиска: ");
        String searchWord = in.nextLine();
        String filePath = "dictionaries/File1.txt";
        FileInputStream fis = new FileInputStream(filePath);
        byte[] content = new byte[fis.available()];
        fis.read(content);
        fis.close();
        String[] lines = new String(content, "Cp1251").split("\n"); // кодировку указать нужную
        int i = 1;
        for (String line : lines) {
            String[] words = line.split(" ");
            int j = 1;
            for (String word : words) {
                if (word.equalsIgnoreCase(searchWord)) {
                    System.out.println("Найдено в " + i + "-й строке, " + j + "-е слово");
                }
                j++;
            }
            i++;
        }
    }
}
