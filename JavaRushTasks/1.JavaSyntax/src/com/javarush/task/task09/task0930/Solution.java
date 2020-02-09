package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        ArrayList<Integer> arrayNumbers = new ArrayList<Integer>();
        ArrayList<String> arrayWords = new ArrayList<String>();
        for(int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                arrayNumbers.add(Integer.parseInt(array[i]));
            } else {
                arrayWords.add(array[i]);
            }
        }

        int arrayNumbersSize = arrayNumbers.size();
        int arrayWordsSize = arrayWords.size();

        Collections.sort(arrayNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        Collections.sort(arrayWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        if(arrayWordsSize>1)
            isGreaterThan(arrayWords.get(0), arrayWords.get(1));

        for(int i = 0; i < arrayWordsSize; i++) {
            array[i] = arrayWords.get(i);
        }
        for(int i = 0; i < arrayNumbersSize; i++) {
            array[i + arrayWordsSize] = arrayNumbers.get(i).toString();
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
