package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.lang.System;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sensence = reader.readLine();
        int lng = sensence.length();
        ArrayList<Character> charListVowel = new ArrayList<Character>();
        ArrayList<Character> charListNotVowel = new ArrayList<Character>();
        for (int i = 0; i<lng; i++) {
            Character a = sensence.charAt(i);
            if(isVowel(a)) {
                charListVowel.add(a);
            }
            else if(a.equals(' ')) {

            }
            else {
                charListNotVowel.add(a);
            }
        }
        for(Character a : charListVowel) {
            System.out.print(a + " ");
        }
        System.out.println();
        for(Character a : charListNotVowel) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}