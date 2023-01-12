package com.endava.calculator.expert;

import com.endava.calculator.basic.BasicOperations;

public interface ExpertOperations extends BasicOperations {

    Double pow(int base, int exponent);

    Double root(int a);

    Long factorial(int n);

    Long factRecursive(int n);

    Double calculate(String s);


}
