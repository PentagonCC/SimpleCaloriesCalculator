package org.example;

import java.util.HashMap;

public class StepTracker {

    private int targetStepsPerDay = 10000;
    private HashMap<Integer, HashMap<Integer, Integer>> calendar = new HashMap<>();
    private HashMap<Integer, Integer> dateWithSteps = new HashMap<>();

    public int getTargetStepsPerDay(){ //for check add target steps
        return targetStepsPerDay;
    }

    public void setTargetStepsPerDay(int steps){
       targetStepsPerDay = steps;
    }

    public void setStepsPerDay(int month, int date, int steps) {
        if(month <=12 && month >= 1 && date >= 1 && date <= 31 && steps >=0) {
            dateWithSteps.put(date, steps);
            calendar.put(month, dateWithSteps);
            if(steps >= targetStepsPerDay){
                System.out.println("Молодец, цель по шагам за день была выполнена");
            }
            else{
                System.out.println("Поднажми ведь до цели оставалось не так уж и много");
            }
        }
        else{
            System.out.println("Попробуйте снова с корректными значениями");

        }
    }

    public void getStatisticPerMonth(int month){//калории, километры, кол-во шагов, среднее количество шагов
        System.out.println("Общее количество шагов, которое вы прошли за месяц:" + getTotalStepsPerMonth(month));
        System.out.println("Общее растояние, которое вы прошли за месяц: " + getKilometrsPerMonth(month));
        System.out.println("Среднее кол-во шагов, которое вы проходили ежедневно в течении месяца: " + getAverageSteps(month));
        System.out.println("Общее количество кило-калорий, которые вы сожгли за месяц: " + getCaloriesPerMonth(month));
    }

    public double getCaloriesPerMonth(int month){
        StepConverter stepConverter = new StepConverter();
        double totalCalories = 0;
        int totalSteps = getTotalStepsPerMonth(month);
        totalCalories = stepConverter.convertToKk(totalSteps);
        return totalCalories;
    }

    public double getKilometrsPerMonth(int month) {
        StepConverter stepConverter = new StepConverter();
        double totalKilometrs = 0;
        int totalSteps = getTotalStepsPerMonth(month);
        totalKilometrs = stepConverter.convertToKm(totalSteps);
        return totalKilometrs;
    }

    public double getAverageSteps(int month){
        return (double) getTotalStepsPerMonth(month)/ 30;
    }

    public int getTotalStepsPerMonth(int month){
        int totalSteps = 0;
        if(calendar.containsKey(month)){
            HashMap<Integer, Integer> tempMap;
            tempMap = calendar.get(month);
            for(Integer step : tempMap.values()){
                totalSteps+=step;
            }
        }
        return totalSteps;
    }

    public HashMap<Integer, HashMap<Integer, Integer>> getCalendar(){ //for check add in hashmap
        return calendar;
    }

}
