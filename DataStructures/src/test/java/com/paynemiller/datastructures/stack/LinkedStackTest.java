package com.paynemiller.datastructures.stack;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest {
  private static final int STACK_SIZE = 5;
  private static final String ERROR_TEXT = "Exceptions encountered when performing Stack operations." +
          "Did you configure your Stack correctly?";

  @Test
  public void testPushPop() {
    Stack<Integer> stack = new LinkedStack<>(STACK_SIZE);
    int firstElement = 1;
    try {
      stack.push(firstElement);
      assertEquals(firstElement, stack.pop(), "LinkedStack is not popping the correct value.");
    } catch (CollectionFullException | CollectionEmptyException e) {
      fail(ERROR_TEXT);
    }
  }

  @Test
  public void testIsFull() {
    Stack<Integer> stack = null;
    try {
      stack = createFullStack();
    } catch (CollectionFullException e) {
      fail(ERROR_TEXT);
    }
    assertTrue(stack.isFull(), "LinkedStack is not returning true for isFull() when actually full.");
  }

  @Test
  public void testPeek() {
    Stack<Integer> stack = new LinkedStack<>(STACK_SIZE);
    int firstElement = 1;
    try {
      stack.push(firstElement);
      assertEquals(firstElement, stack.peek());
    } catch (CollectionFullException | CollectionEmptyException e) {
      fail(ERROR_TEXT);
    }
  }

  @Test
  public void testSize() {
    Stack<Integer> stack = new LinkedStack<>(STACK_SIZE);
    for (int value = 1; value < STACK_SIZE + 1; value++) {
      try {
        stack.push(value);
        assertEquals(value, stack.size(), "LinkedStack is not returning the correct size.");
      } catch (CollectionFullException e) {
        fail(ERROR_TEXT);
        break;
      }
    }
  }

  @Test
  public void testStackFullException() throws CollectionFullException {
    Stack<Integer> stack = createFullStack();
    assertThrows(CollectionFullException.class, () -> stack.push(6), "");
  }

  @Test
  public void testStackEmptyException(){
    Stack<Integer> stack = new LinkedStack<>(STACK_SIZE);
    String errorMessage = "LinkedStack did not throw a CollectionEmptyException when trying to perform a removal operation whilst empty.";
    assertAll(
            () -> assertThrows(CollectionEmptyException.class, stack::peek, errorMessage),
            () -> assertThrows(CollectionEmptyException.class, stack::pop, errorMessage)
    );
  }


  private Stack<Integer> createFullStack() throws CollectionFullException {
    Stack<Integer> stack = new LinkedStack<>(STACK_SIZE);
    for (int value = 1; value < STACK_SIZE + 1; value++) {
      stack.push(value);
    }
    return stack;
  }
}
