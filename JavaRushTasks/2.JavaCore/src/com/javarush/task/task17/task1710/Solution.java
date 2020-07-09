package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat insideDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat outsideDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        try {
            switch (args[0]) {
                case "-c":
                    int id;
                    boolean successAdd = false;
                    switch (args[2]) {
                        case "м":
                            successAdd = allPeople.add(Person.createMale(args[1], insideDateFormat.parse(args[3])));
                            break;
                        case "ж":
                            successAdd = allPeople.add(Person.createFemale(args[1], insideDateFormat.parse(args[3])));
                            break;
                    }
                    if(successAdd)
                        System.out.println(allPeople.size()-1);
                    break;
                case "-u":
                    switch (args[3]) {
                        case "м":
                            Person changedPersonMale = allPeople.get(Integer.parseInt(args[1]));
                            changedPersonMale.setName(args[2]);
                            changedPersonMale.setSex(Sex.MALE);
                            changedPersonMale.setBirthDate(insideDateFormat.parse(args[4]));
                            break;
                        case "ж":
                            Person changedPersonFemale = allPeople.get(Integer.parseInt(args[1]));
                            changedPersonFemale.setName(args[2]);
                            changedPersonFemale.setSex(Sex.FEMALE);
                            changedPersonFemale.setBirthDate(insideDateFormat.parse(args[4]));
                            break;
                    }
                    break;
                case "-d":
                    Person delPerson = allPeople.get(Integer.parseInt(args[1]));
                    delPerson.setBirthDate(null);
                    delPerson.setName(null);
                    delPerson.setSex(null);
                    break;
                case "-i":
                    Person printPerson = allPeople.get(Integer.parseInt(args[1]));
                    switch (printPerson.getSex()) {
                        case MALE:
                            System.out.println(printPerson.getName() + " м " + outsideDateFormat.format(printPerson.getBirthDate()));
                            break;
                        case FEMALE:
                            System.out.println(printPerson.getName() + " ж " + outsideDateFormat.format(printPerson.getBirthDate()));
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
    }
}
