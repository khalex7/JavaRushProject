package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            File file = new File(Statics.FILE_NAME);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while (true) {
                line = reader.readLine();
                if (line == null) break;
                lines.add(line);
            }
        }
        catch (IOException e) {
        }
        catch (ExceptionInInitializerError e) {

        }
        catch (NullPointerException e) {

        }
    }

    public static void main(String[] args) throws ExceptionInInitializerError {
        System.out.println(lines);
    }
}
