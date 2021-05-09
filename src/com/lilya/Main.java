package com.lilya;
import java.util.*;

public class Main {

    ArrayList<String> wordsList = new ArrayList<>();

    Scanner sc;
    Random rand;

    int money;

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();

        words.add("ball");
        words.add("chair");
        words.add("queen");
        words.add("cat");
        words.add("dog");
        words.add("fish");
        words.add("fridge");
        words.add("king");

        Main main = new Main(words);
        main.game();
    }

    public Main(ArrayList<String> words) {

        this.wordsList = words;

        this.sc = new Scanner(System.in);
        this.rand = new Random();

        money = 15;

    }

    public void game() {

        System.out.println("Какой вы выберите уровень сложности?");
        int hard = this.sc.nextInt();

            while (money < 50) {

                if (money <= 0) {
                    System.out.println("Вы изгнаны...");
                    break;
                } else {

                System.out.println("Ваш баланс:" + money);
                System.out.println("Хотите ли вы продолжить игру?");
                System.out.println("1 - да");
                System.out.println("2- нет");

                int back = sc.nextInt();

                    while (back != 1 && back != 2) {
                        System.out.println("Введите корректное значение!");
                        back = this.sc.nextInt();
                    }

                if (back == 1) {

                    String name = this.wordsList.get(rand.nextInt(this.wordsList.size()));
                    String nameInput = ShuffleString.shuffle(name);
                    System.out.println("Как думаете, что это за слово:" + nameInput + "?");
                    String scWords = this.sc.nextLine();

                    if (this.wordsList.contains(scWords)) {
                        if (hard == 1) {
                            System.out.println("Вы угадали! + 10 галлеонов");
                            money = money + 10;
                        } else {
                            System.out.println("Вы угадали! + 5 галлеонов");
                            money = money + 5;
                        }
                    } else {
                        if (hard == 1) {
                            System.out.println("Вы не угадали! - 5 галлеонов");
                            money = money - 5;
                        } else {
                            System.out.println("Вы не угадали! - 10 галлеонов");
                            money = money - 10;
                        }
                    }

                }else{
                    System.out.println("Спасибо за игру!");
                    System.out.println("Ваш баланс:" + money);
                    break;
                }

                if (money >= 50) {
                    System.out.println("Вы получили достаточное количество денег! Поздравляем!");
                    System.out.println("Ваш баланс:" + money);
                    break;
                }
            }
            }
            }
        }

class ShuffleString
{

    public static String shuffle(String s)
    {

        String shuffledString = "";

        while (s.length() != 0)
        {
            int index = (int) Math.floor(Math.random() * s.length());
            char c = s.charAt(index);
            s = s.substring(0,index)+s.substring(index+1);
            shuffledString += c;
        }

        return shuffledString;

    }

}

