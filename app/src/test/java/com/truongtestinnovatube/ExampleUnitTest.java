package com.truongtestinnovatube;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {



    @Test
    public void isNestedString(){
        assertTrue(NestedValidator.isNested("(([]{})(())(<>))"));
    }

    @Test
    public void isNestedString1(){
        assertTrue(NestedValidator.isNested("<())"));
    }

    @Test
    public void isNestedString2(){
        assertTrue(NestedValidator.isNested("[0..1,000,000]"));
    }

    @Test
    public void isNestedString3(){
        assertTrue(NestedValidator.isNested("([{<\" and/or \")]}>"));
    }




}