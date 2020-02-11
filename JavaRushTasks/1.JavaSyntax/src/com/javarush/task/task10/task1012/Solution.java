package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char letter : alphabet) {
            map.put(letter, 0);
        }
        for(String str : list) {
            char[] str1 = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                if (map.get(str1[i])!=null) {
                    Integer a = map.get(str1[i]);
                    map.put(str1[i], a+1 );
                }
            }
        }
        for(char letter : alphabet) {
            System.out.println(letter + " "+ map.get(letter));
        }
    }
}
