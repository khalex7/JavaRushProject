package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public static void main(String[] args) {
    }
    private Solution() {}
    Solution(int a) {}
    protected Solution(String b) {}
    public Solution(int a, String b) {}
}

