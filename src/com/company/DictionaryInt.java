package com.company;

import java.io.IOException;
import java.util.HashMap;

public interface DictionaryInt {
    void add() throws IOException;
    void remove(String key) throws IOException;
    void search(String key);
    HashMap<String, String> input();

    void setFile(String file);
    void setRegFile(String file);
}