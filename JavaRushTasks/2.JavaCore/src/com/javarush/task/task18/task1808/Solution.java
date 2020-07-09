package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            String fileName3 = reader.readLine();
            reader.close();
            FileInputStream file1 = new FileInputStream(fileName1);
            FileOutputStream file2 = new FileOutputStream(fileName2);
            FileOutputStream file3 = new FileOutputStream(fileName3);

            byte[] fileBuffer = new byte[file1.available()];
            int count = file1.read(fileBuffer);
            file2.write(fileBuffer, 0, count/2 + count%2);
            file3.write(fileBuffer, count/2 + count%2, count/2);

            file1.close();
            file2.close();
            file3.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }

    }
}
