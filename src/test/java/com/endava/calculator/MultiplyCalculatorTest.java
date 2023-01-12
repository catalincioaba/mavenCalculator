package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.extensions.TestReporterExtensions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

public class MultiplyCalculatorTest {
    @ExtendWith(TestReporterExtensions.class)

    private Basic basicCalculator;

    @BeforeAll
    public static void setUpAllTests(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests(){
        System.out.println("After All");
    }

    @BeforeEach
    public void setupEachTest(){
        System.out.println("Before Each");
        basicCalculator = new Basic();
    }

    @AfterEach
    public void tearDownEach(){
        System.out.println("After Each");
    }
    @Test
    public void shouldMultiplyNumbers2Operands(){
        //WHEN
        Long result = basicCalculator.multiply(2,3);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(6,result);
    }

    @Test
    public void shouldMultiplyNumbersOperandZero(){
        //WHEN
        Long result = basicCalculator.multiply(3,0);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(0,result);
    }

    @Test
    public void shouldMultiplyNegativeNumbers(){
        //WHEN
        Long result = basicCalculator.multiply(-3,-2);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(6,result);
    }

    @Test
    public void shouldMultiplyNumbersNegativeOperand(){
        //WHEN
        Long result = basicCalculator.multiply(-3,9);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(-27,result);
    }

    @Test
    public void shouldMultiplyMoreThanTwoOperands(){
        //WHEN
        Long result = basicCalculator.multiply(2,3,4);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(24,result);
    }
}
