package com.javarush.task.task14.task1421;

public class Singleton {
    static private Singleton instance = null;
    static public Singleton getInstance() {
        if(instance == null) instance = new Singleton();
        return instance;
    }

    private Singleton() {

    }
}
