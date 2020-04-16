package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        InputStream inStream = new FileInputStream(inputFile);
        int nDec = 0, nNum = 0;
        List<Integer> array = new ArrayList<Integer>();
        array.add(0);
        List<Boolean> arrayMinus = new ArrayList<Boolean>();
        arrayMinus.add(false);
        while (inStream.available() > 0) {
            int a = inStream.read();
            //System.out.println(a);
            if ((char)a >= '0' && (char) a<='9') {
                array.set(nNum, array.get(nNum) * 10 + a - 48);
            }
            else if ((char)a == '-') {
                arrayMinus.set(nNum, true);
            }
            else if (a == 10) {
                nNum++;
                array.add(0);
                arrayMinus.add(false);
            }
        }
        for (int i = 0; i < array.size(); i++ ){
            if(arrayMinus.get(i)) {
                array.set(i, -array.get(i));
            }
        }
        Collections.sort(array, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < array.size(); i++ ){
            if(array.get(i) % 2 == 1 || -array.get(i) % 2 == 1) {
                array.remove(i);
                i--;
            }
        }

        for(Integer i : array) {
            System.out.println(i);
        }
        reader.close();
        inStream.close();
    }
}
