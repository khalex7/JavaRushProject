package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while (true) {
                line = reader.readLine();
                if(line.equals("exit")) break;
                new ReadThread(line);
            }
            reader.close();
        }
        catch (IOException e) {

        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            this.start();
        }
        // implement file reading here - реализуйте чтение из файла тут

        private String fileName;

        @Override
        public void run() {
            try {
                FileInputStream file = new FileInputStream(fileName);
                Map<Character, Integer> map = new HashMap<Character, Integer>();
                while (file.available() > 0) {
                    char symbol = (char) file.read();
                    if(map.get(symbol) != null) {
                        map.put(symbol, map.get(symbol) + 1);
                    }
                    else {
                        map.put(symbol, 1);
                    }
                }
                file.close();
                int max = 0;
                char maxKey = 0;
                for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if(entry.getValue() > max) {
                        max = entry.getValue();
                        maxKey = entry.getKey();
                    }
                }
                Solution.resultMap.put(fileName, (int)maxKey);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
