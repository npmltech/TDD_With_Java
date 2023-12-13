package org.example;

import java.util.stream.IntStream;

import static java.lang.System.*;

public class PrimeNumber {

    public String calculatePrimeNumber(int number) {

        String msg = "It's a prime number.";

        try {
            int $number = Integer.parseInt(String.valueOf(number));
            boolean checkPrimeNum = isGreaterThanOne($number);
            number = $number / 2;
            //
            if (checkPrimeNum || number <= 1) {
                if (IntStream.rangeClosed(2, number).anyMatch(i -> $number % i == 0)) {
                    msg = "It's not a prime number.";
                }
            }
            //
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("Error: Wrong format!");
        }
        //
        return msg;
    }

    private boolean isGreaterThanOne(int number) {
        if (number > 1)
            return true;
        else
            throw new ArithmeticException("It's Wrong! This is a negative number, zero or one!");
    }

    public static void main(String[] args) {
        out.println("\n" + new PrimeNumber().calculatePrimeNumber(17));
    }
}
