package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws CorruptedDataException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileAllLines = reader.readLine();
            String fileForRemoveLines = reader.readLine();

            BufferedReader fr1 = new BufferedReader(new FileReader(fileAllLines));
            BufferedReader fr2 = new BufferedReader(new FileReader(fileForRemoveLines));
            while (true) {
                String line = fr1.readLine();
                if (line == null) break;
                allLines.add(line);
            }
            while (true) {
                String line = fr2.readLine();
                if (line == null) break;
                forRemoveLines.add(line);
            }
            fr1.close();
            fr2.close();
            reader.close();
            new Solution().joinData();
            for (String line : allLines) {
                //System.out.println(line);
            }
        } catch (IOException e) {

        }
    }

    public void joinData() throws CorruptedDataException {
        for (String line : forRemoveLines) {
            if (!allLines.remove(line)) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }
}
