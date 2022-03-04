package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class File {

    public File() {
    }

    private static final String PATH = "resources/File1.txt";

    public static void FileRead() throws IOException{
        try (BufferedReader in = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void AddFile(){

        Scanner in = new Scanner(System.in);
        String text = in.nextLine();


        try {
            FileWriter writer = new FileWriter(PATH, true);
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
        String searchWord = in.nextLine();
        FileInputStream fis = new FileInputStream(PATH);
        byte[] content = new byte[fis.available()];
        fis.read(content);
        fis.close();
        String[] lines = new String(content, StandardCharsets.UTF_8).split("\n"); // кодировку указать нужную
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


    public static void Delete() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH)); PrintWriter writer = new PrintWriter(new FileWriter(PATH))) {

            //File file = new File();
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
        }
    }
}
