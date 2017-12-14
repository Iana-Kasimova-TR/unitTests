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
public class TestDiv {

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
    public long e;

    @Parameter(value = 5)
    public long f;

    @Parameter(value = 6)
    public long result;

    @Parameters(name = "test({0}/{1}={6})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"6", "2", 6, 2, 6, 2, 3},
                {"6", "-2", 6, -2, 6, -2, -3},
                {"28.8", "2.4", 28.8, 2.4, 24, 2, 12},
                {"0", "5", 0, 5, 0, 5, 0},
        });
    }

    @Before
    public void beforeTest(){
        calculator = new Calculator();
    }

    @Test
    public void testDivString(){
        assertThat(calculator.div(Double.parseDouble(a), Double.parseDouble(b)), is((double)result));
    }


    @Test
    public void testDivDouble() {
        assertThat(calculator.div(c, d), is((double) result));
    }

    @Test
    public void testDivLong(){
        assertThat(calculator.div(e, f), is(result));
    }

    @Test
    public void testDivWithPoint(){
        assertThat(calculator.div(3.0, 2.0), is(1.5));
    }

    @Test(expected = Exception.class)
    public void testDivByZeroDouble(){
        calculator.div(3, 0.0);
    }

    @Test(expected = NumberFormatException.class)
    public void testDivByZeroLong(){
        calculator.div(4, 0L);
    }

    @AfterClass
    public static void afterTests(){
        System.out.println("tests are finished!");
    }
}
