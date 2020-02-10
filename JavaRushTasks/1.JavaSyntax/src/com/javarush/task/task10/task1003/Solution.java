package com.javarush.task.task10.task1003;

/* 
Задача №3 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        float f = (float) (short) 128.50;
        //System.out.println(f);
        int i = (short) f;
        //System.out.println(i);
        int b = (int) (i + (byte)f);
        System.out.println(b);
    }
}
