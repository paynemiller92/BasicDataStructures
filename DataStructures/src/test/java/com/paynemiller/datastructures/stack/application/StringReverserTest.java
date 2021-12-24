package com.paynemiller.datastructures.stack.application;

import com.paynemiller.datastructures.stack.ArrayStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringReverserTest {
  @Test
  public void testReverse() {
    String original = "Hello";
    String reversed = "olleH";
    StringReverser stringReverser = new StringReverser(new ArrayStack<>(Character.class, original.length()));
    assertEquals(reversed, stringReverser.reverse(original), "StringReverser is not reversing strings correctly.");
  }
}
