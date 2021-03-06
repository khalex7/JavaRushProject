package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            switch (args[0]) {
                case "-e":
                    encryption(args[1], args[2]);
                    break;
                case "-d":
                    decryption(args[1], args[2]);
                    break;
                default:
                    break;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong args");
        }
    }


    private static void encryption(String fileName, String fileOutputName) {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            FileOutputStream fileOutput = new FileOutputStream(fileOutputName);
            byte[] buffer = new byte[fileInput.available()];
            int count = fileInput.read(buffer);
            Crypt crypt = new Crypt();
            byte[] cipherBuffer = crypt.encrypt(buffer);
            fileOutput.write(cipherBuffer);
            fileOutput.close();
            fileInput.close();
        }
        catch (FileNotFoundException e) {

        }
        catch (IOException e) {

        }
    }
    private static void decryption(String fileName, String fileOutputName) {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            FileOutputStream fileOutput = new FileOutputStream(fileOutputName);
            byte[] buffer = new byte[fileInput.available()];
            int count = fileInput.read(buffer);
            Crypt crypt = new Crypt();
            byte[] cipherBuffer = crypt.encrypt(buffer);
            fileOutput.write(cipherBuffer);
            fileOutput.close();
            fileInput.close();
        }
        catch (FileNotFoundException e) {

        }
        catch (IOException e) {

        }
    }
    private static class Crypt {
        protected byte[] encrypt (byte[] array) {
            for(int i = 0; i < array.length; i++) {
                array[i] = (byte) (~array[i]);
            }
            return array;
        }
        protected byte[] decrypt (byte[] array) {
            for(int i = 0; i < array.length; i++) {
                array[i]= (byte) ~array[i];
            }
            return array;
        }
    }

}
