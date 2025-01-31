package com.example.maven_pp_javafx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandleCalculatorBuilderTest {

    @Test
    void calculate1() {
        CalculatorBuilderManager calc = new CalculatorBuilderManager();
        calc.setCalc(new HandleCalculatorBuilder());

        double result = calc.calculate("4 + 3 * 4");

        assertEquals(16.0, result);
    }

    @Test
    void calculate2() {
        CalculatorBuilderManager calc = new CalculatorBuilderManager();
        calc.setCalc(new HandleCalculatorBuilder());

        double result = calc.calculate("3 + 2 - 7");

        assertEquals(-2.0, result);
    }

    @Test
    void calculate3() {
        CalculatorBuilderManager calc = new CalculatorBuilderManager();
        calc.setCalc(new HandleCalculatorBuilder());

        double result = calc.calculate("4 * (5 - 6) / 3");

        assertEquals((double) -4 /3, result);
    }

    @Test
    void calculate4() {
        CalculatorBuilderManager calc = new CalculatorBuilderManager();
        calc.setCalc(new HandleCalculatorBuilder());

        double result = calc.calculate("0.56 + 0.2 * 4");

        assertEquals(1.36, result);
    }

    @Test
    void calculate5() {
        CalculatorBuilderManager calc = new CalculatorBuilderManager();
        calc.setCalc(new HandleCalculatorBuilder());

        double result = calc.calculate("7 + 25 * 4 / 2");

        assertEquals(57.0, result);
    }
}