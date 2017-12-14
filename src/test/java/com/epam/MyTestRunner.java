package com.epam;

import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.Test;
import org.junit.runner.Result;

/**
 * Unit test for simple App.
 */
public class MyTestRunner {

    public static void main(String[] s){

        Class<?>[] classes = {TestCos.class, TestSum.class};

        Result result = JUnitCore.runClasses(new ParallelComputer(true, true), classes);
        System.out.println(result.getFailures());
    }
}
