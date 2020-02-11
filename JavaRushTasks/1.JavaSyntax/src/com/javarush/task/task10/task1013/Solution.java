package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private String lastname;
        private boolean sex;
        private int age;
        private String job;
        private String home;

        public Human(String name, String lastname, boolean sex, int age, String home) {
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
            this.age = age;
            this.home = home;
        }
        public Human(String name, String lastname, boolean sex, int age) {
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, String home) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.home = home;
        }
        public Human(boolean sex, int age, String job, String home) {
            this.sex = sex;
            this.age = age;
            this.job = job;
            this.home = home;
        }
        public Human(String name, String lastname, boolean sex, int age, String job, String home) {
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
            this.age = age;
            this.job = job;
            this.home = home;
        }
        public Human(String name, String lastname, int age, String job, String home) {
            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.job = job;
            this.home = home;
        }
        public Human(String name, String lastname, String job, String home) {
            this.name = name;
            this.lastname = lastname;
            this.job = job;
            this.home = home;
        }
        public Human(String name, String lastname, boolean sex, String job, String home) {
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
            this.job = job;
            this.home = home;
        }
        public Human() {
        }

    }
}
