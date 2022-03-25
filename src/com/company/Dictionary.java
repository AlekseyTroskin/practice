package com.company;

import java.io.IOException;
import java.util.HashMap;


public class Dictionary implements DictionaryInt{

    private static HashMap<String, String> stringListHashMap = new HashMap<>();
    private String regFile;
    private String pathFileStr;

    public void dictionaryHashMap() throws IOException {
        stringListHashMap = FileService.convertHashMap(pathFileStr);
    }


    @Override
    public String add(String key, String value) throws IOException {
        String ADD_ERROR;
        String regex = "[А-я]+";
        if (key.matches(regFile)) {
            if (value.matches(regex)) {
                stringListHashMap.put(key, value);
                FileService.writeTxt(stringListHashMap,pathFileStr);
                ADD_ERROR = null;
            } else {
                ADD_ERROR = "value";
            }
        } else {
            ADD_ERROR = "key";
        }
        return ADD_ERROR;
    }

    @Override
    public String remove(String key) throws IOException {
        String keySearch = stringListHashMap.get(key);
            if (keySearch != null){
                stringListHashMap.remove(key);
                FileService.writeTxt(stringListHashMap,pathFileStr);
            }
        return keySearch;
    }

    @Override
    public String search(String key) {
        return stringListHashMap.get(key);
    }

    @Override
    public HashMap<String, String> input() {
        return stringListHashMap;
    }

    @Override
    public void setFile(String pathFile) {
        pathFileStr = pathFile;
    }

    @Override
    public void setRegFile(String regFileStr) {
        regFile = regFileStr;
    }

}
