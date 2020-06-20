package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int start = str.indexOf('?') + 1;
        int beginIndex = start;
        int endIndex = start;
        String objValue = null;
        while (endIndex < str.length()) {
            endIndex = str.indexOf('&', endIndex + 1) == -1 ? str.length() : str.indexOf('&', endIndex + 1);
            int equalIndex = str.indexOf('=', beginIndex);
            equalIndex = equalIndex >= endIndex ? endIndex : equalIndex;
            String param = str.substring(beginIndex, equalIndex);
            System.out.print(param + " ");
            if (param.equals("obj"))
                objValue = str.substring(equalIndex+1, endIndex);
            beginIndex = endIndex + 1;
        }
        System.out.println("");
        if(objValue != null) {
            try {
                double tryObjValue = Double.parseDouble(objValue);
                alert(tryObjValue);
            }
            catch (NumberFormatException e) {
                alert(objValue);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}