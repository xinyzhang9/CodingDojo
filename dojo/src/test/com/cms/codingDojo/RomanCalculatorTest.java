package com.cms.codingDojo;

import org.junit.Assert;
import org.junit.Test;

public class RomanCalculatorTest {
    private RomanCalculator romanCalculator = new RomanCalculator();

    @Test
    public void RomanToNum_1() {
        Assert.assertEquals(1, romanCalculator.toNum("I"));
    }

    @Test
    public void RomanToNum_2() {
        Assert.assertEquals(2, romanCalculator.toNum("II"));
    }

    @Test
    public void RomanToNum_4() {
        Assert.assertEquals(4, romanCalculator.toNum("IV"));
    }

    @Test
    public void RomanToNum_9() {
        Assert.assertEquals(9, romanCalculator.toNum("IX"));
    }

    @Test
    public void RomanToNum_40() {
        Assert.assertEquals(40, romanCalculator.toNum("XL"));
    }

    @Test
    public void RomanToNum_49() {
        Assert.assertEquals(49, romanCalculator.toNum("IL"));
    }

    @Test
    public void RomanToNum_104() {
        Assert.assertEquals(104, romanCalculator.toNum("CIV"));
    }

    @Test
    public void RomanToNum_108() {
        Assert.assertEquals(108, romanCalculator.toNum("CVIII"));
    }

    @Test
    public void RomanToNum_1944() {
        Assert.assertEquals(1944, romanCalculator.toNum("MCMXLIV"));
    }

    @Test
    public void NumToRoman_1() {
        Assert.assertEquals("I", romanCalculator.toRoman(1));
    }

    @Test
    public void NumToRoman_2() {
        Assert.assertEquals("II", romanCalculator.toRoman(2));
    }

    @Test
    public void NumToRoman_1944() {
        Assert.assertEquals("MCMXLIV", romanCalculator.toRoman(1944));
    }

    @Test
    public void add_1_1() {
        Assert.assertEquals("II", romanCalculator.add("I","I"));
    }

    @Test
    public void add_359_93() {
        Assert.assertEquals("CDLII", romanCalculator.add("CCCLIX","XCIII"));
    }

    @Test
    public void add_1_2999() {
        Assert.assertEquals("MMM", romanCalculator.add("I","MMCMXCIX"));
    }
}
