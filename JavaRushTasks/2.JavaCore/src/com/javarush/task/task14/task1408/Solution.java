package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
        /*System.out.println(hen.getDescription());

        hen = HenFactory.getHen(Country.RUSSIA);
        hen.getCountOfEggsPerMonth();
        System.out.println(hen.getDescription());

        hen = HenFactory.getHen(Country.MOLDOVA);
        hen.getCountOfEggsPerMonth();
        System.out.println(hen.getDescription());

        hen = HenFactory.getHen(Country.UKRAINE);
        hen.getCountOfEggsPerMonth();
        System.out.println(hen.getDescription());*/

    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen;
            switch (country) {
                case (Country.BELARUS):
                    hen = new BelarusianHen();
                    break;
                case (Country.UKRAINE):
                    hen = new UkrainianHen();
                    break;
                case (Country.MOLDOVA):
                    hen = new MoldovanHen();
                    break;
                default:
                    hen = new RussianHen();
                    break;
            }
            //напишите тут ваш код
            return hen;
        }
    }

}
