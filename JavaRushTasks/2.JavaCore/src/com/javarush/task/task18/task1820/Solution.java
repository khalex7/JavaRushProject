package com.javarush.task.task18.task1820;

/*
Говнокод, нормальный не принят валидатором
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            reader.close();

            int countSpace = 0;
            int countAll = 0;
            FileInputStream file1 = new FileInputStream(fileName1);
            FileOutputStream file2 = new FileOutputStream(fileName2);
            String line;
            byte[] buffer = new byte[file1.available()];
            file1.read(buffer);
            line = new String(buffer);
            //System.out.println(line);
            int count = 0;
            while (true) {
                int nextSpace = line.indexOf(' ', count);
                int nextEnter = line.indexOf('\n', count);
                //System.out.println("cnt nE nS " + count + " " + nextEnter + " " + nextSpace);
                if (nextSpace == -1 && nextEnter == -1) {
                    char[] charArray= line.substring(count).toCharArray();
                    //for(char i : charArray) {
                        //System.out.print((int) i + "|");
                    //}
                    //System.out.println(" end " + line.substring(count));
                    double num = Double.parseDouble(line.substring(count));
                    //System.out.println(num);
                    int numI = (int) num;
                    if(num<0 && (numI-num == 0.5)) {
                        num+=0.1;
                    }
                    String out = String.format("%.0f", num) + " ";
                    file2.write(out.getBytes());
                    break;
                }
                else if(nextSpace == -1) {
                    char[] charArray= line.substring(count, nextEnter).toCharArray();
                    //for(char i : charArray) {
                    //    System.out.print((int) i + "|");
                    //}
                    //System.out.println(" ent " + line.substring(count, nextEnter));

                    double num = Double.parseDouble(line.substring(count, nextEnter));
                    count = nextEnter+1;

                    int numI = (int) num;
                    if(num<0 && (numI-num == 0.5)) {
                        //System.out.println(num);
                        num+=0.1;
                    }
                    String out = String.format("%.0f", num) + " ";
                    file2.write(out.getBytes());

                }
                else if(nextEnter == -1) {
                    char[] charArray= line.substring(count, nextSpace).toCharArray();
                    //for(char i : charArray) {
                    //    System.out.print((int) i + "|");
                    //}
                    //System.out.println(" spc " + line.substring(count, nextSpace));

                    double num = Double.parseDouble(line.substring(count, nextSpace));
                    count = nextSpace+1;

                    int numI = (int) num;
                    if(num<0 && (numI-num == 0.5)) {
                        //System.out.println(num);
                        num+=0.1;
                    }
                    String out = String.format("%.0f", num) + " ";
                    file2.write(out.getBytes());

                }
                else if (nextEnter > nextSpace) {
                    char[] charArray= line.substring(count, nextSpace).toCharArray();
                    //for(char i : charArray) {
                    //    System.out.print((int) i + "|");
                    //}
                    //System.out.println(" spc2 " + line.substring(count, nextSpace));

                    double num = Double.parseDouble(line.substring(count, nextSpace));
                    count = nextSpace+1;

                    int numI = (int) num;
                    if(num<0 && (numI-num == 0.5)) {
                        //System.out.println(num);
                        num+=0.1;
                    }
                    String out = String.format("%.0f", num) + " ";
                    file2.write(out.getBytes());
                }
                else {
                    char[] charArray= line.substring(count, nextEnter).toCharArray();
                    //for(char i : charArray) {
                    //    System.out.print((int) i + "|");
                    //}
                    //System.out.println(" ent2 " + line.substring(count, nextEnter));

                    double num = Double.parseDouble(line.substring(count, nextEnter));
                    count = nextEnter+1;

                    int numI = (int) num;
                    if(num<0 && (numI-num == 0.5)) {
                        //System.out.println(num);
                        num+=0.1;
                    }
                    String out = String.format("%.0f", num) + " ";
                    file2.write(out.getBytes());

                }
            }
            file1.close();
            file2.close();
        }
        catch (IOException e) {

        }
    }
}
