package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String fileName = reader.readLine();
            if(args[0].equals("-c")) {
                //System.out.println("Strat1");
                if(args.length == 4) {
                    //System.out.println("Start2");
                    String productName = args[1];
                    String price = args[2];
                    String quantity = args[3];
                    //for(int i = 1; i < args.length-2; i++) {
                    //    productName+=args[i];
                    //}
                    //File file = new File(fileName);
                    BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                    Integer maxValue = 0;
                    while (true) {
                        String line = fileReader.readLine();
                        if (line == null) break;
                        if(line.indexOf(" ") <= 8 && line.indexOf(" ") >= 0) {
                            //System.out.println("last index of with " + line.indexOf(" "));
                            //System.out.println("read id with" + Integer.parseInt(line.substring(0, 8).substring(0, line.indexOf(" "))));
                            if (Integer.parseInt(line.substring(0, 8).substring(0, line.indexOf(" "))) > maxValue) {
                                maxValue = Integer.parseInt(line.substring(0, 8).substring(0, line.indexOf(" ")));
                            }
                        }
                        else {
                            //System.out.println("last index of without " + line.indexOf(" "));
                            //System.out.println("read id without" + Integer.parseInt(line.substring(0, 8)));
                            if (Integer.parseInt(line.substring(0, 8)) > maxValue) {
                                maxValue = Integer.parseInt(line.substring(0, 8));
                            }
                        }
                    }
                    fileReader.close();
                    if(maxValue!=99999999) maxValue+=1;
                    String id;
                    if(maxValue.toString().length() > 8) id = maxValue.toString().substring(0,8);
                    else id = maxValue.toString();
                    while (id.length() < 8) {
                        id+=" ";
                    }
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
                    BufferedWriter filewriter = new BufferedWriter(new FileWriter(fileName, true));
                    filewriter.newLine();
                    filewriter.write(id + productName + price + quantity);
                    filewriter.close();
                }
            }
        }
        catch (IOException e) {

        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        finally {
            reader.close();
        }
    }
}
