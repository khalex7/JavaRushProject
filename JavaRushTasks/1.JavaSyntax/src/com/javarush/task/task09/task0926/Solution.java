package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] arr1 = new int[5];
        for(int i = 0; i < 5; i++) {
            arr1[i] = i+3;
        }
        list.add(arr1);
        int[] arr2 = new int[2];
        for(int i = 0; i < 2; i++) {
            arr2[i] = i+3;
        }
        list.add(arr2);
        int[] arr3 = new int[4];
        for(int i = 0; i < 4; i++) {
            arr3[i] = i+3;
        }
        list.add(arr3);
        int[] arr4 = new int[7];
        for(int i = 0; i < 7; i++) {
            arr4[i] = i+3;
        }
        list.add(arr4);
        int[] arr5 = new int[0];
        list.add(arr5);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
