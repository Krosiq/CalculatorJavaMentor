package CalculatorJavaMentor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumber {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100);

    private int number;

    RomanNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static List<RomanNumber> getSortedNumbers() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumber e) -> e.number).reversed())
                .collect(Collectors.toList());
    }
}