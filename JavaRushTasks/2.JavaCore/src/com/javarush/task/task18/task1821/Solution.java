package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream file1 = new FileInputStream(args[0]);
            Map<Character, Integer> map = new TreeMap<Character, Integer>();
            //byte[] buffer = new byte[file1.available()];
            while (file1.available()>0) {
                char a = (char) file1.read();
                if(map.get(a) == null)
                    map.put(a, 1);
                else
                    map.put(a, map.get(a)+1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            file1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
