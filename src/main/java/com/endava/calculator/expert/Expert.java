package com.endava.calculator.expert;

import com.endava.calculator.basic.Basic;

public class Expert extends Basic implements ExpertOperations {

    private String[] operators = {"+", "-", "%", "*", "/"};

    public Expert() {
        numberOfDecimals = 10;
    }

    public Expert(int numberOfDecimals) {
        this.numberOfDecimals = numberOfDecimals;
    }

    @Override
    public Double pow(int base, int exponent) {
//        return Math.pow(base,exponent);
        double powerToResult = 1;

        for (int i = 1; i <= Math.abs(exponent); i++) {
            powerToResult *= base;
        }
        if (exponent >= 0) {
            return formatNumber(powerToResult);
        } else {
            return formatNumber(1 / powerToResult);
        }
    }

    @Override
    public Double root(int a) {
        return formatNumber(Math.sqrt(a));
    }

    @Override
    public Long factorial(int n) {
        long result = 1;
        if (n < 0) {
            throw new IllegalArgumentException("You can't calculate factorial for a negative number.");
        } else {
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
        }
        return result;
    }

    @Override
    public Long factRecursive(int n) {
        //n!  = n * (n-1)!

        if (n == 0) {
            return 1L;
        } else if (n > 0) {
            return n * factorial(n - 1);
        } else {
            throw new IllegalArgumentException("You can't calculate factorial for a negative number.");
        }

    }

    @Override
    public Double calculate(String s) {
        //s = (2) + (2 + 2);
        //s = (2 + 3) + (4 + 5);
        boolean hasOperator = false;

//        for (String op : operators) {
//            if (s.contains(op)) {
//                hasOperator = true;
//            }
//        }
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException exception) {
            if (s.contains("(")) {
                int startIndex = s.indexOf("(");
                int endIndex = s.indexOf(")");
                String left = s.substring(0, startIndex);
                String right = s.substring(endIndex + 1);
                String center = s.substring(startIndex + 1, endIndex);

                double resultCenter = calculate(center);
                return calculate(left + resultCenter + right);

            } else {
                for (String op : operators) {
                    int index = s.lastIndexOf(op);
                    if (index == -1) {
                        continue;
                    }

                    String leftSide = s.substring(0, index);
                    if  ( index != 0 && (leftSide.trim().charAt(leftSide.trim().length() - 1) == '+' || leftSide.trim().charAt(leftSide.trim().length() - 1) == '-'
                            || leftSide.trim().charAt(leftSide.trim().length() - 1) == '*' || leftSide.trim().charAt(leftSide.trim().length() - 1) == '/')) {
                        continue;
                    }
                    double leftOperand = index == 0 ? 0.0 : calculate(leftSide);
                    double rightOperand = calculate(s.substring(index + 1));

                    switch (op) {
                        case "+":
                            return add(leftOperand, rightOperand);
                        case "-":
                            return subtract(leftOperand, rightOperand);
                        case "*":
                            return multiply(leftOperand, rightOperand);
                        case "/":
                            return divide(leftOperand, rightOperand);
                        case "%":
                            return leftOperand % rightOperand;
                        default:
                            throw new IllegalArgumentException("Invalid operator " + op);
                    }
                }
                throw new RuntimeException("Operators field needs to have at leas one value.");

            }
        }
    }
}
