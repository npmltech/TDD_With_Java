package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrimeNumberTest {

    private PrimeNumber primeNumber;

    PrimeNumberTest() {
        this.primeNumber = new PrimeNumber();
    }

    @Test
    void shouldBeNotNull() {
        Assertions.assertNotNull(primeNumber.calculatePrimeNumber(2));
    }

    @Test
    void shouldBeAnInstanceOfInteger() {
        Assertions.assertInstanceOf(String.class, primeNumber.calculatePrimeNumber(2));
    }

    @Test
    void shouldBeNotAString() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            primeNumber.calculatePrimeNumber(Integer.parseInt("Test"));
        });
    }

    @Test
    void shouldBeAPositiveNumber() {
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            primeNumber.calculatePrimeNumber(-1);
        });
        Assertions.assertEquals("It's Wrong! This is a negative number, zero or one!", thrown.getMessage());
    }

    @Test
    void shouldBeNotEqualsOne() {
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            primeNumber.calculatePrimeNumber(1);
        });
        Assertions.assertEquals("It's Wrong! This is a negative number, zero or one!", thrown.getMessage());
    }

    @Test
    void shouldBeNotLessThanOne() {
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            primeNumber.calculatePrimeNumber(1);
        });
        Assertions.assertEquals("It's Wrong! This is a negative number, zero or one!", thrown.getMessage());
    }


    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73 , 79, 83, 89, 97})
    void shouldSendAnOKMessageIfDivisibleByItself(int number) {
        Assertions.assertEquals("It's a prime number.", primeNumber.calculatePrimeNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 10, 20, 25, 26, 30, 33, 34})
    void shouldSendANOKMessageIfDivisibleByMoreThanOne(int number) {
        Assertions.assertEquals("It's not a prime number.", primeNumber.calculatePrimeNumber(number));
    }
}
