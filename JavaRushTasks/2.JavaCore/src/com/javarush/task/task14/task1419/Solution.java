package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;
import java.io.*;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            int[] a = new int[5];
            for (int i = 0; i <=5; i--) {
                a[i] = 1;
            }
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = "RRRRRR";
            int i = Integer.parseInt(s);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Integer a = null;
            System.out.println(a+1);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            InputStream inStream = new FileInputStream("/");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
                Thread.currentThread().interrupt();
            }
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Integer[] a = new Integer[-1];
            //a[0] = Integer.valueOf("dddd");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object i = Integer.valueOf(42);
            String s = (String)i;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalArgumentException("bad");

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalMonitorStateException("bad");

        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
