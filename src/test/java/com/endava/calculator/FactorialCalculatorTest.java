package com.endava.calculator;

import com.endava.calculator.expert.Expert;
import com.endava.extensions.TestReporterExtensions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

public class FactorialCalculatorTest {
    @ExtendWith(TestReporterExtensions.class)

//    @TestExecutionListeners(value = {CustomTestExecutionListener.class});


    private Expert expertCalculator;

//    @BeforeTestExecution
//    expertCalculator =new Expert();


    @BeforeEach
    public void setupEachTest() {
        expertCalculator = new Expert();
    }

    @Test
    public void shouldCalculateFactorial() {
        //WHEN
        Long result = expertCalculator.factorial(3);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(6, result);
    }

    @Test
    public void shouldCalculateFactRecursive() {
        //WHEN
        Long result = expertCalculator.factRecursive(3);

        //THEN
        System.out.println(result);
        Assertions.assertEquals(6, result);
    }

}
