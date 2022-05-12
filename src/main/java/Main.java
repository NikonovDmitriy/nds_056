package main;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner write = new Scanner(System.in);
    public static Random rand = new Random();

    public static boolean exit = false;
    public static boolean win = false;

    public static int currentAttempts = 0;
    public static int bestAttempts = 100;
    public static int number = 0;

    public static void main(String[] args) {
        while (!exit) {
            number = rand.nextInt(100);
            win = false;
            System.out.println("Кинуть кости:\n");
            Menu();
        }
    }

    public static void Game() {
        System.out.println("Твоё число:");
        int step = write.nextInt();
        currentAttempts++;
        if (step == number) {
            win = true;
            System.out.println("Поздравляю, ты победил");
            System.out.println("Загаданное число: " + number);
            System.out.println("Количество попыток: " + currentAttempts);
            System.out.println("Лучшая игра: " + bestAttempts + "\n");
            if (currentAttempts < bestAttempts) bestAttempts = currentAttempts;
        }
        else if (step > number) System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
        else System.out.println("Я сам в шоке, но, загаданное число больше, брат");
    }

    public static void Result() {
        System.out.println("Последняя игра: " + currentAttempts);
        System.out.println("Лучшая игра: " + bestAttempts + "\n");
    }

    public static void Menu() {
        System.out.println("Играть (game)");
        System.out.println("Результат (result)");
        System.out.println("Выход (exit)\n");
        System.out.println("Твой вариант:");
        String choice = write.next();
        switch(choice){
            case "game":
                currentAttempts = 0;
                while(!win){
                    Game();
                }
                break;
            case "result":
                Result();
                Menu();
                break;
            case "exit":
                exit = true;
                break;
            default:
                System.out.println("Такого варианта нет.\n");
                Menu();
                break;
        }
    }
}