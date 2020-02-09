package com.javarush.task.task09.task0929;

import java.io.*;
import java.text.ParseException;

/* 
Обогатим код функциональностью!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();

        try {
            InputStream fileInputStream = getInputStream(sourceFileName);

            String destinationFileName = reader.readLine();
            OutputStream fileOutputStream = getOutputStream(destinationFileName);

            int data;
            while ((data = fileInputStream.read())!= -1)
            {
                fileOutputStream.write(data);
            }

            fileInputStream.close();
            fileOutputStream.close();
        }
        catch (FileNotFoundException exception) {
            System.out.println("Файл не существует");
            sourceFileName = reader.readLine();
            InputStream fileInputStream = getInputStream(sourceFileName);

            String destinationFileName = reader.readLine();
            OutputStream fileOutputStream = getOutputStream(destinationFileName);

            int data;
            while ((data = fileInputStream.read())!= -1)
            {
                fileOutputStream.write(data);
            }

            fileInputStream.close();
            fileOutputStream.close();
        }

    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

