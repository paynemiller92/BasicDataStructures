package com.paynemiller.datastructures.stack.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringReverserTest {
  @Test
  public void testReverse() {
    String original = "Hello";
    String reversed = "olleH";
    StringReverser stringReverser = new StringReverser();
    assertEquals(reversed, stringReverser.reverse(original), "StringReverser is not reversing strings correctly.");
  }
}
