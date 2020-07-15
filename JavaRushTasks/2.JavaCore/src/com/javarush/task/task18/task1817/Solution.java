package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            int countSpace = 0;
            int countAll = 0;
            FileInputStream fs = new FileInputStream(args[0]);
            while (fs.available()>0) {
                int symbol = fs.read();
                countAll++;
                if ((char) symbol == ' ')
                    countSpace++;
            }
            fs.close();
            Double num = (double) countSpace / countAll * 100.;
            String result = String.format("%.2f",num);
            System.out.println(result);
        }
        catch (IOException e) {

        }
    }
}
