package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new FirstThread());
        threads.add(new SecondThread());
        threads.add(new ThirdThread());
        threads.add(new FourthThread());
        threads.add(new FithThread());
    }

    public static void main(String[] args) {

    }
    public static class FirstThread extends Thread {
        @Override
        public void run() {
            while (true){

            }
        }
    }
    public static class SecondThread extends Thread {
        @Override
        public void run() {
            while (true){
                try {
                    sleep(1);
                }
                catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                    break;
                }

            }
        }
    }
    public static class ThirdThread extends Thread {
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Ура");
                    sleep(500);
                }
                catch (InterruptedException e) {
                }

            }
        }
    }
    public static class FourthThread extends Thread implements Message{
        @Override
        public void showWarning() {
            interrupt();
        }

        @Override
        public void run() {
            while (isAlive()) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    break;
                }
            }
        }
    }
    public static class FithThread extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        @Override
        public void run() {
            while (true){
                try {
                    sum+=Integer.parseInt(reader.readLine());
                }
                catch (NumberFormatException e) {
                    System.out.println(sum);
                    break;
                }
                catch (IOException e) {

                }

            }
        }
    }
}