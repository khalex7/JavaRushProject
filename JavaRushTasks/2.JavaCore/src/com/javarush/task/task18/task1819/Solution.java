package com.javarush.task.task18.task1819;

/* 
Объединение файлов
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

            byte[] fileBuffer1 = new byte[file1.available()];
            file1.read(fileBuffer1);
            file1.close();

            FileOutputStream file12 = new FileOutputStream(fileName1);
            FileInputStream file2 = new FileInputStream(fileName2);

            byte[] fileBuffer = new byte[file2.available()];
            file2.read(fileBuffer);
            file12.write(fileBuffer);
            file12.write(fileBuffer1);

            file12.close();
            file2.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
