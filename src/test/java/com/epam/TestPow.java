package com.epam;

import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Iana_Kasimova on 12/12/2017.
 */
@RunWith(value = Parameterized.class)
public class TestPow {


    Calculator calculator;

    @Parameter(value = 0)
    public String a;

    @Parameter(value = 1)
    public String b;

    @Parameter(value = 2)
    public double c;

    @Parameter(value = 3)
    public double d;

    @Parameter(value = 4)
    public double result;

    @Parameters(name = "test({0}^{1}={4})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"4", "0.5", 4, 0.5, 2},
                {"2", "-1", 2, -1, 0.5},
                {"-3", "2", -3, 2, 9},
                {"0", "5", 0, 5, 0},
                {"5", "0", 5, 0, 1},
        });
    }

    @Before
    public void beforeTest(){
        calculator = new Calculator();
    }

    @Test
    public void testPowString(){
        assertThat(calculator.pow(Double.parseDouble(a), Double.parseDouble(b)), is(result));
    }


    @Test
    public void testPowDouble() {
        assertThat(calculator.pow(c, d), is(result));
    }

    @AfterClass
    public static void afterTests(){
        System.out.println("tests are finished!");
    }
}
