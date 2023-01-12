package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.extensions.TestReporterExtensions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {

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

    @Tags( {@Tag("smoke"), @Tag("UI")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b) {
        //GIVEN
//        Basic basicCalculator = new Basic();
        //WHEN
        long result = basicCalculator.add(a, b);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(2, result);
    }

   public static List<Arguments> numberProvider(){
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(0,2));
        arguments.add(Arguments.of(2,0));
       return arguments;
   }
    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers(){

        //WHEN
        long result = basicCalculator.add(-2, -4);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(-6, result);

    }
    @Tags( {@Tag("smoke"), @Tag("API")})
    @Test
    public void shouldAddNumbersGivenBigNumbers(){

        //WHEN
        long result = basicCalculator.add(Integer.MAX_VALUE, 1);

        //THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @CsvSource({"1,2,3","2,4,5"})
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldAddMoreThan2Operands(int a1,int a2, int a3){

        //WHEN
        Long result = basicCalculator.add(a1, a2, a3);

        //THEN
        System.out.println(result);
//        Assertions.assertEquals(60,result);

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
