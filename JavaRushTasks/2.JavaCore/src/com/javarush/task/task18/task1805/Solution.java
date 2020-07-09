package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            FileInputStream file = new FileInputStream(fileName);
            Map<Integer, Integer> count = new HashMap<Integer, Integer>();
            while (file.available()>0) {
                Integer key = file.read();
                if(count.containsKey(key)) {
                    int value = count.get(key);
                    count.put(key, value+1);
                }
                else {
                    count.put(key, 1);
                }
            }
            file.close();
            reader.close();
            Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(count);

            for (Map.Entry<Integer, Integer> pair : sortedMap.entrySet()) {
                System.out.print(pair.getKey() + " ");;
            }

        }
        catch (IOException e) {

        }

    }
}