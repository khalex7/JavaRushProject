package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            FileInputStream file = new FileInputStream(fileName);
            int count = 0;
            while (file.available() > 0) {
                count = file.read() == ',' ? count+1 : count;
            }
            file.close();
            System.out.println(count);
        }
        catch (IOException e) {

        }
    }
}
