package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String fileName = reader.readLine();
            reader.close();
            if(args[0].equals("-u")) {
                //System.out.println("Strat1");
                if(args.length == 5) {
                    //System.out.println("Start2");
                    List<String> list = new ArrayList<String>();
                    String idStr = args[1];
                    String productName = args[2];
                    String price = args[3];
                    String quantity = args[4];
                    int id = Integer.parseInt(idStr);
                    if(productName.length() > 30) productName = productName.substring(0,30);
                    while (productName.length() < 30) {
                        productName+=" ";
                    }
                    if(price.length() > 8) price = price.substring(0,8);
                    while (price.length() < 8) {
                        price+=" ";
                    }
                    if(quantity.length() > 4) quantity = quantity.substring(0,4);
                    while (quantity.length() < 4) {
                        quantity+=" ";
                    }
                    //for(int i = 1; i < args.length-2; i++) {
                    //    productName+=args[i];
                    //}
                    //File file = new File(fileName);
                    BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                    Integer equalValue = id;
                    while (true) {
                        String line = fileReader.readLine();
                        if (line == null) break;
                        if(line.indexOf(" ") < 8 && line.indexOf(" ") >= 0) {
                            //System.out.println("last index of with " + line.indexOf(" "));
                            //System.out.println("read id with" + Integer.parseInt(line.substring(0, 8).substring(0, line.indexOf(" "))));
                            if (equalValue.equals(Integer.parseInt(line.substring(0, 8).substring(0, line.indexOf(" "))))) {
                                line = line.substring(0, 8) + productName + price + quantity;
                            }
                        }
                        else {
                            //System.out.println("last index of without " + line.indexOf(" "));
                            //System.out.println("read id without" + Integer.parseInt(line.substring(0, 8)));
                            if (equalValue.equals(Integer.parseInt(line.substring(0, 8)))) {
                                line = line.substring(0, 8) + productName + price + quantity;
                            }
                        }
                        list.add(line);
                    }
                    fileReader.close();

                    BufferedWriter filewriter = new BufferedWriter(new FileWriter(fileName));
                    for(String line : list) {
                        filewriter.write(line);
                        filewriter.newLine();
                    }
                    filewriter.close();
                }
            }
            if(args[0].equals("-d")) {
                //System.out.println("Strat1");
                if(args.length == 2) {
                    //System.out.println("Start2");
                    List<String> list = new ArrayList<String>();
                    String idStr = args[1];
                    int id = Integer.parseInt(idStr);

                    BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                    Integer equalValue = id;
                    while (true) {
                        String line = fileReader.readLine();
                        if (line == null) break;
                        if(line.indexOf(" ") < 8 && line.indexOf(" ") >= 0) {
                            //System.out.println("last index of with " + line.indexOf(" "));
                            //System.out.println("read id with" + Integer.parseInt(line.substring(0, 8).substring(0, line.indexOf(" "))));
                            if (!equalValue.equals(Integer.parseInt(line.substring(0, 8).substring(0, line.indexOf(" "))))) {
                                list.add(line);
                            }
                        }
                        else {
                            //System.out.println("last index of without " + line.indexOf(" "));
                            //System.out.println("read id without" + Integer.parseInt(line.substring(0, 8)));
                            if (!equalValue.equals(Integer.parseInt(line.substring(0, 8)))) {
                                list.add(line);
                            }
                        }
                    }
                    fileReader.close();

                    BufferedWriter filewriter = new BufferedWriter(new FileWriter(fileName));
                    for(String line : list) {
                        filewriter.write(line);
                        filewriter.newLine();
                    }
                    filewriter.close();
                }
            }
        }
        catch (IOException e) {

        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
    }
}
