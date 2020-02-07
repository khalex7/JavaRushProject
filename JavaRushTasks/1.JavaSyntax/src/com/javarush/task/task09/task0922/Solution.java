package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormatFirst = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date dateFirst = dateFormatFirst.parse(reader.readLine());
        SimpleDateFormat dateFormatSecond = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        String dateSecond = dateFormatSecond.format(dateFirst);

        System.out.println(dateSecond.toUpperCase());
    }
}
