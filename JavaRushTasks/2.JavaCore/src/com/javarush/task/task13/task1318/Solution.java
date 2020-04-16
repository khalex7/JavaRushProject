package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        InputStream inStream = new FileInputStream(inputFile);
        while (inStream.available() > 0) {
            int a = inStream.read();
            System.out.print((char)a);
        }
        inStream.close();
        reader.close();
    }
}