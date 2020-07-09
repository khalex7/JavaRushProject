package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        try {
            SimpleDateFormat insideDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            SimpleDateFormat outsideDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        if ((args.length - 1) % 3 != 0) {
                            System.out.println("Wrong data");
                            break;
                        }
                        int countArgs = (args.length - 1) / 3;
                        for (int i = 0; i < countArgs; i++) {
                            int i3 = i * 3;
                            boolean successAdd = false;
                            switch (args[i3 + 2]) {
                                case "м":
                                    successAdd = allPeople.add(Person.createMale(args[i3 + 1], insideDateFormat.parse(args[i3 + 3])));
                                    break;
                                case "ж":
                                    successAdd = allPeople.add(Person.createFemale(args[i3 + 1], insideDateFormat.parse(args[i3 + 3])));
                                    break;
                            }
                            if (successAdd)
                                System.out.println(allPeople.size() - 1);
                        }
                        break;
                    }
                case "-u":
                    synchronized (allPeople) {
                        if ((args.length - 1) % 4 != 0) {
                            System.out.println("Wrong data");
                            break;
                        }
                        int countArgs = (args.length - 1) / 4;
                        for (int i = 0; i < countArgs; i++) {
                            int i4 = i*4;
                            switch (args[i4 + 3]) {
                                case "м":
                                    Person changedPersonMale = allPeople.get(Integer.parseInt(args[i4 + 1]));
                                    changedPersonMale.setName(args[i4 + 2]);
                                    changedPersonMale.setSex(Sex.MALE);
                                    changedPersonMale.setBirthDate(insideDateFormat.parse(args[i4 + 4]));
                                    break;
                                case "ж":
                                    Person changedPersonFemale = allPeople.get(Integer.parseInt(args[i4 + 1]));
                                    changedPersonFemale.setName(args[i4 + 2]);
                                    changedPersonFemale.setSex(Sex.FEMALE);
                                    changedPersonFemale.setBirthDate(insideDateFormat.parse(args[i4 + 4]));
                                    break;
                            }
                        }
                        break;
                    }
                case "-d":
                    synchronized (allPeople) {
                        for(int i = 1; i < args.length; i++) {
                            Person delPerson = allPeople.get(Integer.parseInt(args[i]));
                            delPerson.setBirthDate(null);
                            delPerson.setName(null);
                            delPerson.setSex(null);
                        }
                        break;
                    }
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            Person printPerson = allPeople.get(Integer.parseInt(args[i]));
                            switch (printPerson.getSex()) {
                                case MALE:
                                    System.out.println(printPerson.getName() + " м " + outsideDateFormat.format(printPerson.getBirthDate()));
                                    break;
                                case FEMALE:
                                    System.out.println(printPerson.getName() + " ж " + outsideDateFormat.format(printPerson.getBirthDate()));
                                    break;
                            }
                        }
                        break;
                    }
                default:
                    synchronized (allPeople) {
                        break;
                    }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        catch (ParseException e) {
            System.out.println(e);
        }
    }
}
