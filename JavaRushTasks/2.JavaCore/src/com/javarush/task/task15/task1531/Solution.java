package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        String result = "0";
        if (n == 0) {
            result = "1";
        }
        else if (n > 0) {
            BigInteger resultBI = new BigInteger("1");
            for(Integer i = 1; i <= n; i++) {
                resultBI = resultBI.multiply(new BigInteger(i.toString()));
            }
            result = resultBI.toString();
        }
        return result;
    }
}
