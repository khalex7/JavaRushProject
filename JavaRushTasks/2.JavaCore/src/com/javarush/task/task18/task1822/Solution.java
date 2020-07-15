package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            Integer id = Integer.parseInt(args[0]);
            if (id == null) return;
            while (file.ready()) {
                char sym;
                String line = "";
                line = file.readLine();
                if(id.equals(Integer.parseInt(line.substring(0, line.indexOf(" "))))) {
                    System.out.println(line);
                }
            }
            file.close();

        }
        catch (IOException e) {

        }
    }
}
