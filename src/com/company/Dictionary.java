package com.company;

import java.util.HashMap;

import static com.company.Menu.*;

public class Dictionary implements DictionaryInt{

    private HashMap<String, String> stringListHashMap = new HashMap<String, String>();
    private String regFile = null;
    private String pathFileStr = null;
    private FileService fileService = new FileService();


    @Override
    public void add(String keyRegex1, String keyRegex2) {
        String regex = "[А-я]+";
        if (d==1) {
            if(key.matches(keyRegex1)){
                if (value.matches(regex)){
                    stringListHashMap.put(key,value);
                    System.out.println("Запись успешно добавлена!");
                }
                else {
                    System.out.println("Неверное значение!");
                }
            }
            else {
                System.out.println("Ключ неверный!");
            }
        }
        else {
            if(key.matches(keyRegex2)){
                if (value.matches(regex)){
                    stringListHashMap.put(key,value);
                    System.out.println("Запись успешно добавлена!");
                }
                else System.out.println("Неверное значение!");
            }
            else {
                System.out.println("Ключ неверный!");
            }
        }
    }

    @Override
    public void remove(String key) {
        String keyDel = in.nextLine();
        String keySearch = stringListHashMap.get(keyDel);
        if (keySearch != null){
            stringListHashMap.remove(keyDel);
        }
        else {
            System.out.println("Значения с таким ключом не найдено!");
        }
    }

    @Override
    public void search(String key) {
        searchWord = stringListHashMap.get(key);
        if (searchWord != null) {
            System.out.println(searchWord);
        }
        else {
            System.out.println("Значения с таким ключом не найдено!");
        }
    }

    @Override
    public HashMap<String, String> input() {
        return stringListHashMap;
    }

    @Override
    public void setFile(String pathFile) {
         pathFileStr = pathFile;
         fileService.setPathFile(pathFileStr);
    }

    @Override
    public void setRegFile(String regFileStr) {
        regFile = regFileStr;
    }
}
