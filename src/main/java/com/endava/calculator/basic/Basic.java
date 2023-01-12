package com.endava.calculator.basic;

public class Basic implements BasicOperations {

    protected int numberOfDecimals;

    public Basic(){
        numberOfDecimals = 10;
    }

    public Basic(int numberOfDecimals){
        this.numberOfDecimals = numberOfDecimals;
    }

    @Override
    public Long add(int... numbers) {
        long sum = 0;

        for (int element : numbers) {
            sum += element;
        }
        return sum;
    }

    @Override
    public Long add(long... numbers) {
        long sum = 0;

        for (long element : numbers) {
            sum += element;
        }
        return sum;
    }

    @Override
    public Double add(double... numbers) {
        double sum = 0;

        for (double element : numbers) {
            sum += element;
        }
        return sum;
    }

    @Override
    public Integer subtract(int... numbers) {
        int difference = numbers[0];

        if (numbers.length == 1) {
            throw new RuntimeException("Provided collection must contain more than one element.");
        } else {
            for (int i = 1; i < numbers.length; i++) {
                difference -= numbers[i];
            }
        }
        return difference;
    }

    @Override
    public Long subtract(long... numbers) {
        long difference = numbers[0];

        if (numbers.length == 1) {
            throw new RuntimeException("Provided collection must contain more than one element.");
        } else {
            for (int i = 1; i < numbers.length; i++) {
                difference -= numbers[i];
            }
        }

        return difference;
    }

    @Override
    public Double subtract(double... numbers) {
        double difference = numbers[0];
        if (numbers.length == 1) {
            throw new RuntimeException("Provided collection must contain more than one element.");
        } else {
            for (int i = 1; i < numbers.length; i++) {
                difference -= numbers[i];
            }
        }
        return difference;
    }

    @Override
    public Long multiply(int... numbers) {
        long product = 1;

        for (int element : numbers) {
            product *= element;
        }
        return product;
    }

    @Override
    public Long multiply(long... numbers) {
        long product = 1;

        for (long element : numbers) {
            product *= element;
        }
        return product;
    }

    @Override
    public Double multiply(double... numbers) {
        double product = 1;

        for (double element : numbers) {
            product *= element;
        }
        return product;
    }

    @Override
    public Double divide(int... numbers) {
        double quotient = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            quotient /= numbers[i];
        }

        return formatNumber(quotient);
    }

    @Override
    public Double divide(long... numbers) {
        double quotient = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            quotient /= numbers[i];
        }
        return formatNumber(quotient);
    }

    @Override
    public Double divide(double... numbers) {
        double quotient = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            quotient /= numbers[i];
        }
        return formatNumber(quotient);
    }


    protected double formatNumber(double number){
        String s = String.format("%." + numberOfDecimals +"f", number);
        return Double.parseDouble(s);
    }
}
