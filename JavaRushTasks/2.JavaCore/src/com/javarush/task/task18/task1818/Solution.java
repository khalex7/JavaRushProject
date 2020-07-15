package com.javarush.task.task18.task1818;

/* 
Два в одном
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
            FileOutputStream file1 = new FileOutputStream(fileName1);
            FileInputStream file2 = new FileInputStream(fileName2);
            FileInputStream file3 = new FileInputStream(fileName3);

            byte[] fileBuffer = new byte[file2.available()];
            int count2 = file2.read(fileBuffer);
            file1.write(fileBuffer);
            fileBuffer = new byte[file3.available()];
            int count3 = file3.read(fileBuffer);
            file1.write(fileBuffer);

            file1.close();
            file2.close();
            file3.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }

    }
}