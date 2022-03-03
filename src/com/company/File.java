package com.company;

import java.io.*;
import java.util.Scanner;

public class File {

    public File(String s) {
    }

    public static void FileRead() throws IOException{
        try (BufferedReader in = new BufferedReader(new FileReader("resources/File1.txt"))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void AddFile(){
        String filePath = "resources/File1.txt";

        Scanner in = new Scanner(System.in);
        System.out.print("Введите данные: ");
        String text = in.nextLine();


        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text+"\r\n");
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println();
        }
    }

    public static void Search() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово для поиска: ");
        String searchWord = in.nextLine();
        String filePath = "resources/File1.txt";
        FileInputStream fis = new FileInputStream(filePath);
        byte[] content = new byte[fis.available()];
        fis.read(content);
        fis.close();
        String[] lines = new String(content, "UTF8").split("\n"); // кодировку указать нужную
        int i = 1;
        int k = 0;
        for (String line : lines) {
            String[] words = line.split(" ");
            int j = 1;
            for (String word : words) {
                if (word.equalsIgnoreCase(searchWord)) {
                    System.out.println("слово " + word + " Найдено в " + i + "-й строке, " + j + "-е слово");
                    k = k + 1;
                }
                j++;
            }
            i++;
        }
        if (k<1){
            System.out.println("слово " +searchWord +" не найдено");
        }
    }


    public static void Delete() throws IOException {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {

            File file = new File("resources/File2.txt");
            String fileToWrite = "resources/File1.txt";
            reader = new BufferedReader(new FileReader("resources/File1.txt"));
            writer = new PrintWriter(new FileWriter(fileToWrite));
            int current = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                int index = 1;
                if (current != index) {
                    writer.println(line);
                }
                current++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
    }
}
