package com.company;

import java.util.HashMap;

public interface DictionaryInt {
    void add();
    void remove(String key);
    void search(String key);
    HashMap<String, String> input();

    void setFile(String file);
    void setRegFile(String file);
}