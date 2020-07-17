package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Solution_Chapter {
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

    private static Key key;

    static {
        byte[] encoded = {-101, 18, -119, 80, 43, 66, 6, -42, -95, 31, 85, -44, -118, -97, 82, 77, -45, 110, 44, 12, 32, -15, -36, -110, -121, -99, -45, 36, -128, -122, -22, -49};
        key = new SecretKeySpec(encoded, "AES");
    }

    ;

    private static void encryption(String fileName, String fileOutputName) {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            FileOutputStream fileOutput = new FileOutputStream(fileOutputName);
            byte[] buffer = new byte[fileInput.available()];
            int count = fileInput.read(buffer);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherBuffer = cipher.doFinal(buffer);
            fileOutput.write(cipherBuffer);
            fileOutput.close();
            fileInput.close();
        }
        catch (FileNotFoundException e) {

        }
        catch (IOException e) {

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
    private static void decryption(String fileName, String fileOutputName) {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            FileOutputStream fileOutput = new FileOutputStream(fileOutputName);
            byte[] buffer = new byte[fileInput.available()];
            int count = fileInput.read(buffer);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] cipherBuffer = cipher.doFinal(buffer);
            fileOutput.write(cipherBuffer);
            fileOutput.close();
            fileInput.close();

            System.out.println("Dec: " + key.getEncoded());     }
        catch (FileNotFoundException e) {

        }
        catch (IOException e) {

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

}
