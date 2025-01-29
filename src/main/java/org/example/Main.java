package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        boolean checkWork = true;

        while (checkWork) {
            printMenu();
            int answer = input.nextInt();
            if (answer == 1) {
                System.out.println("Введите месяц(1-12), день(1-31) и пройденные шаги за день");
                stepTracker.setStepsPerDay(input.nextInt(), input.nextInt(), input.nextInt());
                System.out.println(stepTracker.getCalendar());
            } else if (answer == 2) {
                stepTracker.setTargetStepsPerDay(input.nextInt());
            } else if (answer == 3) {
                stepTracker.getStatisticPerMonth(input.nextInt());
            } else if (answer == 4) {
                System.out.println("Досвидания");
                checkWork = false;
            }

        }
    }

    public static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Изменить цель по количеству шагов в день (по умолчанию: 10000)");
        System.out.println("3 - Вывести статистику за определенный месяц");
        System.out.println("4 - Выйти из приложения");
    }
}