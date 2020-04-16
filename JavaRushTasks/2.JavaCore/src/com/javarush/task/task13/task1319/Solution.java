package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outputFile = reader.readLine();
        File file = new File(outputFile);
        FileWriter fileWriter = new FileWriter(file); // поток, который подключается к текстовому файлу
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // соединяем FileWriter с BufferedWriter

        while (true) {
            String a = reader.readLine();
            if ( a == null) {
                break;
            }

            bufferedWriter.write(a + "\n");
            String s = "\n";
            if (a.equals("exit"))
                break;
        }
        bufferedWriter.close();
    }
}
