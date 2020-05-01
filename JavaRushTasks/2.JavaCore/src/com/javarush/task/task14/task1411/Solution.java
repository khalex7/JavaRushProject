package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        //boolean check = true;
        while(true) {
            key = reader.readLine();
            if (key.equals("user")) {
                person = new Person.User();
            }
            else if (key.equals("loser")) {
                person = new Person.Loser();
            }
            else if (key.equals("coder")) {
                person = new Person.Coder();
            }
            else if (key.equals("proger")) {
                person = new Person.Proger();
            }
            else  {
                //key = null;
                break;
            }
            //System.out.println("haha");

            /*switch (key) {
                case "user":
                    person = new Person.User();
                    doWork(person);
                    break;
                case "loser":
                    person = new Person.Loser();
                    doWork(person);
                    break;
                case "coder":
                    person = new Person.Coder();
                    doWork(person);
                    break;
                case "proger":
                    person = new Person.Proger();
                    doWork(person);
                    break;
                default: {
                    check = false;
                    break;
                }
            }*/




            //создаем объект, пункт 2
            doWork(person); //вызываем doWork
        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User){
            ((Person.User) person).live();
        }
        else if (person instanceof Person.Loser){
            ((Person.Loser) person).doNothing();
        }
        else if (person instanceof Person.Coder){
            ((Person.Coder) person).writeCode();
        }
        else if (person instanceof Person.Proger){
            ((Person.Proger) person).enjoy();
        }
    }


}
