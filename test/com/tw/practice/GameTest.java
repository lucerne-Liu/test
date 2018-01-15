package com.tw.practice;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class GameTest {

    @Mock
    private NumberGenerator mockedGenerator = Mockito.mock(NumberGenerator.class);

    @Mock
    private Printer mockedPrinter = Mockito.mock(Printer.class);

    @Mock
    private NumberReader mockedReader = Mockito.mock(NumberReader.class);

    @Test
    public void shouldReturn4A0BWhenInputSameNumber() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()).thenReturn("1234");
        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);
        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("you win");
    }
    @Test
    public void shouldReturn0A0BWhenInputDifferentNumber() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()).thenReturn("5678");
        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);
        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("0A0B");
    }
    @Test
    public void shouldReturn0A4BWhenInputNumberAllInWrongPlace() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()).thenReturn("4321");
        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);
        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("0A4B");
    }
    @Test
    public void shouldReturn2A2BWhenInputFourRightNumberButTwoInWrongPlace() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()).thenReturn("1324");
        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);
        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("2A2B");
    }
}