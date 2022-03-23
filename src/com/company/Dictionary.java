package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import static com.company.Menu.*;

public class Dictionary implements DictionaryInt{

    private HashMap<String, String> stringListHashMap = new HashMap<>();
    private String regFile = null;
    private String pathFileStr = null;
    private final FileService fileService = new FileService();

    public HashMap<String,String> dictionaryHashMap () throws IOException {
        stringListHashMap = FileService.convertHashMap();
        return stringListHashMap;
    }


    @Override
    public void add() throws IOException {
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
        String keyDel = in.nextLine();
        String keySearch = stringListHashMap.get(keyDel);
            if (keySearch != null){
                stringListHashMap.remove(keyDel);
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
         pathFileStr = pathFile;
         fileService.setPathFile();
    }

    @Override
    public void setRegFile(String regFileStr) {
        regFile = regFileStr;
    }

    public String getPathFileStr() {
        return pathFileStr;
    }

    public void setPathFileStr(String pathFileStr) {
        this.pathFileStr = pathFileStr;
    }
}
