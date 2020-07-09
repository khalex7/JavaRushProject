package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            FileInputStream file = new FileInputStream(fileName);
            int max = Integer.MAX_VALUE;
            while (file.available()>0) {
                int bt = file.read();
                max = bt < max ? bt : max;
            }
            System.out.println(max);
            file.close();
            reader.close();
        }
        catch (IOException e) {

        }
    }
}
