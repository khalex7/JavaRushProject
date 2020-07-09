package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            reader.close();
            FileInputStream file1 = new FileInputStream(fileName1);
            FileOutputStream file2 = new FileOutputStream(fileName2);

            byte[] fileBuffer = new byte[file1.available()];
            int count = file1.read(fileBuffer);
            for (int i = count-1; i >=0; i--) {
                file2.write(fileBuffer[i]);
            }
            file1.close();
            file2.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }

    }
}