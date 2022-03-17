package com.company;

import java.util.HashMap;

public interface DictionaryInt {
    void add(String keyRegex1, String keyRegex2);
    void remove(String key);
    void search(String key);
    HashMap<String, String> input();

    void setFile(String file);
    void setRegFile(String file);
}