package com.cms.codingDojo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();
    @Test
    public void empty() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void one() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void two() {
        assertEquals(2, stringCalculator.add("2"));
    }
    
    @Test
    public void one_two() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void one_two_three() {
        assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    public void one_new_line() {
        assertEquals(3, stringCalculator.add("1\n2"));
    }

    @Test
    public void new_line_and_comma() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void delimiter_one_two() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void delimiter_two_three() {
        assertEquals(5, stringCalculator.add("//;\n2;3"));
    }

    @Test
    public void delimiter_colon() {
        assertEquals(5, stringCalculator.add("//:\n2:3"));
    }

    @Test
    public void ignore_big_number() {
        assertEquals(2, stringCalculator.add("1001,2"));
    }

    @Test
    public void delimiters() {
        assertEquals(3, stringCalculator.add("//[:]\n1:2"));
    }

    @Test
    public void delimiters_2() {
        assertEquals(3, stringCalculator.add("//[ABC]\n1ABC2"));
    }

    @Test
    public void multiple_delimeters() {
        assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }
}
