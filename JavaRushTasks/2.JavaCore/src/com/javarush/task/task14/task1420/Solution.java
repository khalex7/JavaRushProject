package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        {
            int number1 = Integer.parseInt(reader.readLine());
            int number2 = Integer.parseInt(reader.readLine());

            if (number1 <= 0) throw new Exception();
            if (number2 <= 0) throw new Exception();

            while (number1 != 0 && number2 != 0) {
                if (number1 > number2) {
                    number1 %= number2;
                } else {
                    number2 %= number1;
                }
            }
            System.out.println(number1 + number2);
        }
    }
}
