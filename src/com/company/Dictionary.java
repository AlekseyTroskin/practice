package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import static com.company.Menu.*;

public class Dictionary implements DictionaryInt{

    private static HashMap<String, String> stringListHashMap = new HashMap<>();
    private String regFile = null;
    private String pathFileStr = null;
    private final FileService fileService = new FileService();

    public static void dictionaryHashMap() throws IOException {
        stringListHashMap = FileService.convertHashMap();
    }


    @Override
    public void add(String key, String value) throws IOException {
        String regex = "[А-я]+";
        if (key.matches(regFile)) {
            if (value.matches(regex)) {
                stringListHashMap.put(key, value);
                System.out.println("Запись успешно добавлена!");
            } else {
                System.out.println("Неверное значение!");
            }
        } else {
            System.out.println("Ключ неверный!");
        }
        FileService.writeTxt(stringListHashMap);
    }

    @Override
    public void remove(String key) throws IOException {
        String keySearch = stringListHashMap.get(key);
            if (keySearch != null){
                stringListHashMap.remove(key);
                System.out.println("Запись успешно удалена!");
            }
            else {
                System.out.println("Значения с таким ключом не найдено!");
             }

        FileService.writeTxt(stringListHashMap);
    }

    @Override
    public void search(String key) {
            searchWord = stringListHashMap.get(key);
            System.out.println(Objects.requireNonNullElse(searchWord, "Значения с таким ключом не найдено!"));
    }

    @Override
    public HashMap<String, String> input() {
        return stringListHashMap;
    }

    @Override
    public void setFile(String pathFile) {
        fileService.setPathFile();
        pathFileStr = pathFile;
    }

    @Override
    public void setRegFile(String regFileStr) {
        regFile = regFileStr;
    }

}
