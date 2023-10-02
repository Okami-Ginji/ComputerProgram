/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Library;
import java.util.Scanner;
import view.Menu;

/**
 *
 * @author Administrator
 */
public class ComputerProgram extends Menu<String>{
    
    static String[] mc = {"Normal Calculator", "BMI Calculator", "Exit"};
    static Scanner in = new  Scanner(System.in);
    Library l;
    
    public ComputerProgram() {
        super("       Calculator Program ", mc);
        l = new Library();
    }
    @Override
    public void execute(int n) {
        switch(n) {
            case 1:
                normalCalculator();
                break;
            case 2:
                BMICalculator();
                break;
            case 3:
                System.exit(0);
        }
    }

    //allow user input number
    public double inputNumber() {
        double number = l.checkInputDouble("Enter number");
        return number;
    }

    //allow user calculator normal
    public void normalCalculator() {
        double memory;
        memory = inputNumber();
        while (true) {
            System.out.print("Enter operator: ");
            String operator = l.checkInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                memory /= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }

    }

    //display result BMI status
    public String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    //allow user BMI calculator
    public void BMICalculator() {
        double weight = l.checkInputDouble("Enter Weight(kg)");
        double height = l.checkInputDouble("Enter Height(cm)");
        double bmi = weight*10000 / (height*height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}
