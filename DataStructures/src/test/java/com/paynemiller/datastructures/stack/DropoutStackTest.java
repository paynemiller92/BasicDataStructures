package com.paynemiller.datastructures.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DropoutStackTest {
  private static final int SIZE = 5;
  private static final String ERROR_MESSAGE = "Something went wrong while using your Stack. Please ensure that the Stack is being used correctly!";

  @Test
  public void testInitialPush() {
    Stack<Integer> stack = new DropoutStack<>(SIZE);
    int firstElement = 1;
    try {
      stack.push(firstElement);
      assertAll(
              () -> assertFalse(stack.isEmpty()),
              () -> assertFalse(stack.isFull()),
              () -> assertEquals(firstElement, stack.peek()),
              () -> assertEquals(firstElement, stack.pop())
      );
    } catch (Exception e) {
      fail(ERROR_MESSAGE);
    }
  }

  @Test
  public void testFullStack() {
    Stack<Integer> stack = new DropoutStack<>(1);
    int firstElement = 1;
    try {
      stack.push(firstElement);
      assertAll(
              () -> assertFalse(stack.isEmpty()),
              () -> assertTrue(stack.isFull()),
              () -> assertEquals(firstElement, stack.peek()),
              () -> assertEquals(firstElement, stack.pop()),
              () -> assertTrue(stack.isEmpty()),
              () -> assertFalse(stack.isFull())
      );
    } catch (Exception e) {
      fail(ERROR_MESSAGE);
    }
  }

  @Test
  public void testDropout() {
    Stack<Integer> stack = new DropoutStack<>(3);
    int firstElement = 1;
    int secondElement = 2;
    int thirdElement = 3;
    int fourthElement = 4;
    try {
      stack.push(firstElement);
      stack.push(secondElement);
      stack.push(thirdElement);
      stack.push(fourthElement);
      assertAll(
              () -> assertFalse(stack.isEmpty()),
              () -> assertTrue(stack.isFull()),
              () -> assertEquals(fourthElement, stack.peek()),
              () -> assertEquals(fourthElement, stack.pop()),
              () -> assertFalse(stack.isEmpty()),
              () -> assertFalse(stack.isFull()),
              () -> assertEquals(thirdElement, stack.peek()),
              () -> assertEquals(thirdElement, stack.pop())
      );
    } catch (Exception e) {
      fail(ERROR_MESSAGE);
    }
  }
}
