package com.company;

import java.io.IOException;
import java.util.HashMap;

public interface DictionaryInt {
    String add(String key, String value) throws IOException;

    String remove(String key) throws IOException;
    String search(String key);
    HashMap<String, String> input();
    void dictionaryHashMap() throws IOException;

    void setFile(String file);
    void setRegFile(String file);
}