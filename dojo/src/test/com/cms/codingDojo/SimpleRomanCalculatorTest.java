package com.cms.codingDojo;

import org.junit.Assert;
import org.junit.Test;

public class SimpleRomanCalculatorTest {
    private SimpleRomanCalculator calculator = new SimpleRomanCalculator();

    @Test
    public void add_1_1() {
        Assert.assertEquals("II", calculator.add("I", "I"));
    }

    @Test
    public void add_1_2() {
        Assert.assertEquals("III", calculator.add("I", "II"));
    }

    @Test
    public void add_2_3() {
        Assert.assertEquals("V", calculator.add("II", "III"));
    }

    @Test
    public void add_6_4() {
        Assert.assertEquals("X", calculator.add("VI", "IV"));
    }

    @Test
    public void add_1_3() {
        Assert.assertEquals("IV", calculator.add("I", "III"));
    }

    @Test
    public void add_359_93() {
        Assert.assertEquals("CDLII", calculator.add("CCCLIX","XCIII"));
    }

    @Test
    public void add_1_2999() {
        Assert.assertEquals("MMM", calculator.add("I","MMCMXCIX"));
    }

    @Test
    public void minus_2_1() {
        Assert.assertEquals("I", calculator.subtract("II","I"));
    }

    @Test
    public void minus_10_1() {
        Assert.assertEquals("IX", calculator.subtract("X","I"));
    }

    @Test
    public void minus_452_359() {
        Assert.assertEquals("XCIII", calculator.subtract("CDLII","CCCLIX"));
    }

    @Test
    public void minus_3000_1() {
        Assert.assertEquals("MMCMXCIX", calculator.subtract("MMM","I"));
    }
}
