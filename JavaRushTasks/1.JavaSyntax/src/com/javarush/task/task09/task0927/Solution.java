package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }

    public static void main(String[] args) throws Exception {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> mappy = new HashMap<>();
        mappy.put("Vaska", new Cat("Vaska"));
        mappy.put("Barsik", new Cat("Barsik"));
        mappy.put("Mashka", new Cat("Mashka"));
        mappy.put("Yashka", new Cat("Yaska"));
        mappy.put("Zorka", new Cat("Zorka"));
        mappy.put("Boris", new Cat("Boris"));
        mappy.put("Matroskin", new Cat("Matroskin"));
        mappy.put("Belka", new Cat("Belka"));
        mappy.put("Lubka", new Cat("Lubka"));
        mappy.put("Begemoth", new Cat("Begemoth"));
        return  mappy;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<>();
        for(Map.Entry<String, Cat> entry : map.entrySet()) {
            set.add(entry.getValue());
        }

        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }
}
