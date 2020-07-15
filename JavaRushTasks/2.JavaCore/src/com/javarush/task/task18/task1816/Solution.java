package com.javarush.task.task18.task1816;

/* 
Английские буквы 65-90, 97-122
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            int count = 0;
            FileInputStream fs = new FileInputStream(args[0]);
            while (fs.available()>0) {
                int symbol = fs.read();
                if( ((symbol >= (int) 'a') && (symbol <= (int) 'z')) || (symbol >= 'A') && (symbol <= 'Z') )
                    count++;
            }
            fs.close();
            System.out.println(count);
        }
        catch (IOException e) {

        }

    }
}
