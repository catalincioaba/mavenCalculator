package com.endava.calculator.basic;

public interface BasicOperations {

    Long add(int... numbers);

    Long add(long... numbers);

    Double add(double... numbers);

    Integer subtract(int... numbers);
    Long subtract(long... numbers);
    Double subtract(double... numbers);

    Long multiply(int... numbers);
    Long multiply(long... numbers);
    Double multiply(double... numbers);

    Double divide(int... numbers);
    Double divide(long... numbers);
    Double divide(double... numbers);


}
