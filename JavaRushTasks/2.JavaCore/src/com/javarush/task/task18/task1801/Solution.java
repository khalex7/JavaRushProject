package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            FileInputStream file = new FileInputStream(fileName);
            int max = Integer.MIN_VALUE;
            while (file.available()>0) {
                int bt = file.read();
                max = bt > max ? bt : max;
            }
            System.out.println(max);
            file.close();
            reader.close();
        }
        catch (IOException e) {

        }
    }
}
