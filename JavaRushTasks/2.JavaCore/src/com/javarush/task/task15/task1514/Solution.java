package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>() {
        {
            put(3. , "efe");
            put(4. , "esuu");
            put(5. , "ese=w");
            put(6. , "est");
            put(7. , "edf");
        }
    };

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
