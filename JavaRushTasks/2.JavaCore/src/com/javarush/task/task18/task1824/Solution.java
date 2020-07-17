package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                line = reader.readLine();
                if(line.equals("exit")) {
                    //System.out.println("Exit");
                    break;
                }
                FileInputStream fileStream = new FileInputStream(line);
                list.add(fileStream);
                //System.out.println("Add " + fileStream);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(line);
        }
        finally {
            reader.close();
            //System.out.println("Reader close");
            for(FileInputStream fileStream : list) {
                if(fileStream != null) fileStream.close();
                //System.out.println("Close " + fileStream);
            }
        }
    }
    public static String line = null;
    public static List<FileInputStream> list = new ArrayList<FileInputStream>();
}
