package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class File {

    public static HashMap<Object, String> dictionary = new HashMap<>();
    public static Scanner in = new Scanner(System.in);
    private static final String PATH = "src/resources/File1.txt";

    public static void convertHashMap() throws IOException {
        Scanner filescan = new Scanner(new FileReader(PATH));
        while (filescan.hasNextLine()) {
            String[] columns = filescan.nextLine().split(":");
            dictionary.put(columns[0], columns[1]);
        }
    }

    public File() {
    }


    public static void FileRead() throws IOException{
        try (BufferedReader in = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = in.readLine()) != null) {
                for (HashMap.Entry entry : dictionary.entrySet()) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
            }
        }
    }

    public static void AddFile(){


        System.out.println("Введите ключ: ");
        String key = in.nextLine();
        System.out.println("Введите значение: ");
        String value = in.nextLine();
        dictionary.put(key,value);
            /*FileWriter writer = new FileWriter(PATH, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text+"\r\n");
            bufferWriter.close();*/
    }

    public static void Search() throws IOException {
        String key = in.nextLine();
        String searchWord = dictionary.get(key);
        System.out.println(searchWord);
        /*FileInputStream fis = new FileInputStream(PATH);
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
        }*/
    }


    public static void Delete() {
        /*try (BufferedReader reader = new BufferedReader(new FileReader(PATH)); PrintWriter writer = new PrintWriter(new FileWriter(PATH))) {

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
        }*/
        System.out.print("Введите ключ значения,которое хотите удалить: ");
        String keyDel = in.nextLine();
        dictionary.remove(keyDel);
        for (HashMap.Entry entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
