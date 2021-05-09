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

        System.out.println("����� �� �������� ������� ���������?");
        int hard = this.sc.nextInt();

            while (money < 50) {

                if (money <= 0) {
                    System.out.println("�� �������...");
                    break;
                } else {

                System.out.println("��� ������:" + money);
                System.out.println("������ �� �� ���������� ����?");
                System.out.println("1 - ��");
                System.out.println("2- ���");

                int back = sc.nextInt();

                    while (back != 1 && back != 2) {
                        System.out.println("������� ���������� ��������!");
                        back = this.sc.nextInt();
                    }

                if (back == 1) {

                    String name = this.wordsList.get(rand.nextInt(this.wordsList.size()));
                    String nameInput = ShuffleString.shuffle(name);
                    System.out.println("��� �������, ��� ��� �� �����:" + nameInput + "?");
                    String scWords = this.sc.nextLine();

                    if (this.wordsList.contains(scWords)) {
                        if (hard == 1) {
                            System.out.println("�� �������! + 10 ���������");
                            money = money + 10;
                        } else {
                            System.out.println("�� �������! + 5 ���������");
                            money = money + 5;
                        }
                    } else {
                        if (hard == 1) {
                            System.out.println("�� �� �������! - 5 ���������");
                            money = money - 5;
                        } else {
                            System.out.println("�� �� �������! - 10 ���������");
                            money = money - 10;
                        }
                    }

                }else{
                    System.out.println("������� �� ����!");
                    System.out.println("��� ������:" + money);
                    break;
                }

                if (money >= 50) {
                    System.out.println("�� �������� ����������� ���������� �����! �����������!");
                    System.out.println("��� ������:" + money);
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

