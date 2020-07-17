package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = null;
            Map<Integer, String> map = new TreeMap<Integer, String>();
            while (true) {
                line = reader.readLine();
                if(line.equals("end")) {
                    //System.out.println("End");
                    break;
                }
                FileInputStream fileStream = new FileInputStream(line);
                map.put((Integer.parseInt(line.substring(line.lastIndexOf(".part")+5))), line);
            }
            reader.close();
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                String fileOutputName = entry.getValue().substring(0, entry.getValue().lastIndexOf(".part"));
                FileOutputStream fileOutput = new FileOutputStream(fileOutputName, true);
                FileInputStream fileInput = new FileInputStream(entry.getValue());
                byte[] buffer = new byte[fileInput.available()];
                int count = fileInput.read(buffer);
                fileOutput.write(buffer, 0, count);
                //fileOutput.write('\n');
                fileInput.close();
                fileOutput.close();
            }
            //fileOutput.close();

        }
        catch (FileNotFoundException e) {
        }
        reader.close();
    }
}
