package CalculatorJavaMentor;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Calculator {
    public void calculating(String inputStr) {
        String[] subInputStr;
        String strDelimeter = " ";
        subInputStr = inputStr.split(strDelimeter);
        String firstNumberStr = "";
        String mathSymbol = "";
        String secondNumberStr = "";

        for (int i = 0; i < subInputStr.length; i++) {
            if (i == 0) {
                firstNumberStr = subInputStr[i];
            } else if (i == 1) {
                mathSymbol = subInputStr[i];
            } else if (i == 2) {
                secondNumberStr = subInputStr[i];
            } else {
                throw new IllegalArgumentException("Можно ввести только два числа и один оператор между ними");
            }
        }

        if (isThisArabicNumber(firstNumberStr) && isThisArabicNumber(secondNumberStr)) {
            int firstNumber = parseInt(firstNumberStr);
            int secondNumber = parseInt(secondNumberStr);
            if ((firstNumber <= 0) || (firstNumber > 10)) {
                throw new IllegalArgumentException(firstNumber + " это число не находится в промежутке между 0 и 10");
            }
            if ((secondNumber <= 0) || (secondNumber > 10)) {
                throw new IllegalArgumentException(firstNumber + " это число не находится в промежутке между 0 и 10");
            }
            int result = 0;

            switch (mathSymbol) {
                case "+":
                    result = firstNumber + secondNumber;
                    System.out.println(result);
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    System.out.println(result);
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    System.out.println(result);
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    System.out.println(result);
                    break;
                default:
                    throw new IllegalArgumentException("Ошибка введена некоректная математическая операция");
            }

        }
        else {
            int firstNumber = convertNumberRomanToArabic(firstNumberStr);
            int secondNumber = convertNumberRomanToArabic(secondNumberStr);
            int result = 0;
            String resultRoman = "";

            switch (mathSymbol) {
                case "+":
                    result = firstNumber + secondNumber;
                    resultRoman = convertNumberArabicToRoman(result);
                    System.out.println(resultRoman);
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    resultRoman = convertNumberArabicToRoman(result);
                    System.out.println(resultRoman);
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    resultRoman = convertNumberArabicToRoman(result);
                    System.out.println(resultRoman);
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    resultRoman = convertNumberArabicToRoman(result);
                    System.out.println(resultRoman);
                    break;
                default:
                    throw new IllegalArgumentException("Ошибка введена некоректная математическая операция");
            }
        }
    }

    public static boolean isThisArabicNumber(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    public static int convertNumberRomanToArabic(String input) {
        String inputRomanNumber = input.toUpperCase();
        int result = 0;

        List<RomanNumber> inputRomanNumbers = RomanNumber.getSortedNumbers();

        int i = 0;

        while ((inputRomanNumber.length() > 0) && (i < inputRomanNumbers.size())) {
            RomanNumber symbol = inputRomanNumbers.get(i);
            if (inputRomanNumber.startsWith(symbol.name())) {
                result += symbol.getNumber();
                inputRomanNumber = inputRomanNumber.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (inputRomanNumber.length() > 0) {
            throw new IllegalArgumentException(input + " это число невозможно конвертировать");
        }

        return result;
    }

    public static String convertNumberArabicToRoman(int number) {
        if ((number <= 0) || (number > 10)) {
            throw new IllegalArgumentException(number + " это число не находится в промежутке между 0 и 10");
        }

        List<RomanNumber> romanNumbers = RomanNumber.getSortedNumbers();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumbers.size())) {
            RomanNumber currentSymbol = romanNumbers.get(i);
            if (currentSymbol.getNumber() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getNumber();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
