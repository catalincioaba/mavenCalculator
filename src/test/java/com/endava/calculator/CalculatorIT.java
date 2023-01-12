package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.extensions.TestReporterExtensions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

public class CalculatorIT {
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
    public void shouldAddNumbersGivenOperand0() {
        //GIVEN
//        Basic basicCalculator = new Basic();
        //WHEN
        long result = basicCalculator.add(2, 0);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void shouldAddNegativeNumbers(){

        //WHEN
        long result = basicCalculator.add(-2, -4);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(-6, result);

    }
    @Test
    public void shouldAddNumbersGivenBigNumbers(){

        //WHEN
        long result = basicCalculator.add(Integer.MAX_VALUE, 1);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddMoreThan2Operands(){

        //WHEN
        Long result = basicCalculator.add(2, 3, 5,20,30);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(60,result);

    }

    @Test
    public void shouldAddNoOperands(){

        //WHEN
        Long result = basicCalculator.add();

        //THEN
        System.out.println(result);
        Assertions.assertEquals(0,result);
    }

    @Test
    public void shouldAddOneOperand(){
        //WHEN
        Long result = basicCalculator.add(167);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(167,result);
    }
}
