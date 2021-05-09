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
        main.start();
        main.game();
    }

    public Main(ArrayList<String> words) {

        this.wordsList = words;

        this.sc = new Scanner(System.in);
        this.rand = new Random();

        money = 15;

    }

    public void game() {

        System.out.println("What level of difficulty do you choose?");
        System.out.println("1 - easy");
        System.out.println("2 - hard");
        int hard = this.sc.nextInt();

            while (money < 50) {

                if (money <= 0) {
                    System.out.println("You are banished...");
                    break;
                } else {

                System.out.println("Your balance:" + money);
                System.out.println("Do you want to continue playing?");
                System.out.println("1 - yes");
                System.out.println("2- no");

                int back = sc.nextInt();

                    while (back != 1 && back != 2) {
                        System.out.println("Enter the correct value!");
                        back = this.sc.nextInt();
                    }

                if (back == 1) {

                    String name = this.wordsList.get(rand.nextInt(this.wordsList.size()));
                    String comeBack = name;
                    if(comeBack != name) {
                        String nameInput = ShuffleString.shuffle(name);
                        System.out.println("What do you think that word is?:" + nameInput + "?");
                    }
                    else {
                        name = this.wordsList.get(rand.nextInt(this.wordsList.size()));
                        comeBack = name;
                        String nameInput = ShuffleString.shuffle(name);
                        System.out.println("What do you think that word is?:" + nameInput + "?");
                    }

                    String word = this.sc.nextLine();
                    String scWords = this.sc.nextLine();

                    if (this.wordsList.contains(scWords)) {
                        if (hard == 1) {
                            System.out.println("You guessed it! + 10 galleons");
                            money = money + 10;
                        } else {
                            System.out.println("You guessed it! + 5 galleons");
                            money = money + 5;
                        }
                    } else {
                        if (hard == 1) {
                            System.out.println("You didn't guess right! - 5 galleons");
                            money = money - 5;
                        } else {
                            System.out.println("You didn't guess right! - 10 galleons");
                            money = money - 10;
                        }
                    }

                }else{
                    System.out.println("Thank you for playing!!");
                    System.out.println("Your balance::" + money);
                    break;
                }

                if (money >= 50) {
                    System.out.println("You have received enough money! Congratulate!");
                    System.out.println("Your balance::" + money);
                    break;
                }
            }
            }
            }

            public void start() {

                System.out.println("*******");
                System.out.println("Hi! You are a human living on the planet Quinel.");
                System.out.println("Unfortunately, you took out a lot of loans and need to pay them urgently, ");
                System.out.println("otherwise you will have to return back to your home planet and quit a prestigious job.");
                System.out.println("The term is limited and the salary will not have time to come.");
                System.out.println("You found the right game that will help you pay for everything.");
                System.out.println("But if you have no money at all, you will be banished.");
                System.out.println("To pay for the credits, win 50 galleons in the game! ");
                System.out.println("Good luck!");
                System.out.println("*******");

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

