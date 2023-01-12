package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;

import java.util.Arrays;

public class TestCalculator {
    public static void main(String[] args) {
        BasicOperations basicCalculator = new Basic();
        BasicOperations basicCalculator1 = new Basic(3);
//        System.out.println(basicCalculator.add(2, 3));
//        System.out.println(basicCalculator.subtract(2, -3));
//        System.out.println(basicCalculator.multiply(2, 6));
        System.out.println(basicCalculator.divide(10, 3));
        System.out.println(basicCalculator1.divide(10, 3));
//        System.out.println(basicCalculator.divide(5, 0));
//        System.out.println(basicCalculator.multiply(3.5d, 2.3d));
//
//        System.out.println(basicCalculator.add(new int[]{2, 3, 4}));
//        System.out.println(basicCalculator.add(2,3,4,5));

//        System.out.println(basicCalculator.subtract(1,3,6,9));
//        System.out.println(basicCalculator.subtract(1.3,6.5,9.6));
//
        ExpertOperations expertOperations = new Expert();
//        System.out.println(expertOperations.pow(2,3));
//        System.out.println(expertOperations.pow(2,-1));
//
//        System.out.println(expertOperations.root(4));
//        System.out.println(expertOperations.root(7));
        System.out.println(expertOperations.factorial(3));

//        System.out.println(sumOfMultiplesOfThreeOrFive(10));

//        System.out.println(getVowelNumber("Ana are mere."));
//        System.out.println(getVowelNumber3("Ana are mere."));


        System.out.println(basicCalculator.multiply(5, 6, 3));
        System.out.println(basicCalculator.multiply(5.5, 3, 1));
        System.out.println(basicCalculator.multiply(5f, 3f, 2f));

        System.out.println(basicCalculator.divide(9, 9, 2));
        System.out.println(basicCalculator.divide(10.5d, 2.0d, 5.25d));
        System.out.println(basicCalculator.divide(10f, 2f, 2f));

        ExpertOperations expert = new Expert(3);
        System.out.println(expert.root(5));

        System.out.println(expert.calculate("2+3"));
        System.out.println(expert.calculate("22+33"));
        System.out.println(expert.calculate("22.5+33"));
        System.out.println(expert.calculate("22.5 + 33.5"));
        System.out.println(expert.calculate("22.5 + 33.5 + 5"));
        System.out.println(expert.calculate("3*2"));
        System.out.println(expert.calculate("3+2*4"));
        System.out.println(expert.calculate("5%3"));
        System.out.println(expert.calculate("-3+5"));
        System.out.println(expert.calculate("-3*5"));
        System.out.println(expert.calculate("-3-5"));
        System.out.println(expert.calculate("2*(3+2)/5"));
        System.out.println(expert.calculate("(3+2)/5"));
        System.out.println(expert.calculate("2 * (3+2)"));
        System.out.println(expert.calculate("2 * (-3+2)"));
        System.out.println(expert.calculate("2 + (-3-5)"));
        System.out.println(expert.calculate("2 + (-3-5) * (-7-5)"));
    }

    public static int sumOfMultiplesOfThreeOrFive(int number) {
        int sum = 0;
        if (number < 0) {
            return 0;
        }
        for (int i = 1; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int getVowelNumber(String line) {
        int vowelCounter = 0;
        String text = line.toLowerCase();


        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'i' || text.charAt(i) == 'o' || text.charAt(i) == 'u') {
                vowelCounter++;
            }
        }
        return vowelCounter;
    }

    public static int getVowelNumber2(String line) {
        int vowelCounter = 0;
        String text = line.toLowerCase();
        char[] characters = text.toCharArray();

        for (char element : characters) {
            switch (element) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelCounter++;
            }
        }
        return vowelCounter;
    }

    public static int getVowelNumber3(String line) {
        int vowelCounter = 0;
        String text = line.toLowerCase();
        char[] characters = text.toCharArray();

        for (char element : characters) {
            if (Arrays.asList('a', 'e', 'i', 'o', 'u').contains(element)) {
                vowelCounter++;
            }
        }
        return vowelCounter;
    }
}