package org.example;

public class StepConverter {

    public double convertToKm(int countStep){
        return (double) (countStep * 75) / 100000;
    }

    public double convertToKk(int countStep){
        return (double) (countStep * 50) / 1000;
    }
}
