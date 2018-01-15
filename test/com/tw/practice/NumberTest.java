package com.tw.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberTest {
    @Test
    public void shouldReturn4A0BWhenInputSameNumber(){
        Number number = new Number("1234");
        assertEquals("4A0B", number.compare("1234"));
    }
    @Test
    public void shouldReturn0A0BWhenInputDifferentNumber(){
        Number number = new Number("1234");
        assertEquals("0A0B", number.compare("5678"));
    }
    @Test
    public void shouldReturn0A4BWhenInputNumberAllInWrongPlace(){
        Number number = new Number("1234");
        assertEquals("0A4B", number.compare("4321"));
    }
    @Test
    public void shouldReturn2A2BWhenInputFourRightNumberButTwoInWrongPlace(){
        Number number = new Number("1234");
        assertEquals("2A2B", number.compare("1324"));
    }
}