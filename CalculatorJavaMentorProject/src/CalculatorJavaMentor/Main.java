package CalculatorJavaMentor;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение которое хотите вычислить:");
        Scanner inputVar = new Scanner(System.in);
        String inputStr = inputVar.nextLine();
        Calculator Calc = new Calculator();
        Calc.calculating(inputStr);
    }
}

