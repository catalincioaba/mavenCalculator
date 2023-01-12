package com.endava.calculator;

import com.endava.calculator.expert.Expert;
import com.endava.extensions.TestReporterExtensions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RaiseToPowerCalculatorTest {
    @ExtendWith(TestReporterExtensions.class)

    private Expert expertCalculator;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    @BeforeAll
    public static void setUpAllTests() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setupEachTest() {
        System.out.println("Before Each");
        expertCalculator = new Expert();
    }

    @AfterEach
    public void tearDownEach() {
        System.out.println("After Each");
    }

    @Test
    public void shouldRaiseToPowerBaseAndExponentPositive() {
        //WHEN
        Double result = expertCalculator.pow(2, 3);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void shouldRaiseToPowerBasePozExponentNegative() {
        //WHEN
        Double result = expertCalculator.pow(2, -3);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(0.125, result);
    }

    @Test
    public void shouldRaiseToPowerBaseNegExponentPoz(){
        //WHEN
        Double result = expertCalculator.pow(-2, 3);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(-8, result);
    }

    @Test
    public void shouldRaiseToPowerBaseAndExponentNegative(){
        //WHEN
        Double result = expertCalculator.pow(-3, -3);

//        DECIMAL_FORMAT.setRoundingMode(RoundingMode.DOWN);
        //THEN
        System.out.println(result);
        Assertions.assertEquals(-0.037037037, result);
//        Assertions.assertEquals(-0.03, DECIMAL_FORMAT.format(result));
    }

    @Test
    public void shouldRaiseToPowerExponentZero(){
        //WHEN
        Double result = expertCalculator.pow(100, 0);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(1, result);
    }

}
