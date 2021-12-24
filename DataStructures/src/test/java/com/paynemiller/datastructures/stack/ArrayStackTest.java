package com.paynemiller.datastructures.stack;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {
  private static final int SIZE = 5;
  private final Stack<Integer> stack = new ArrayStack<>(Integer.class, SIZE);

  @Test
  public void testPushAndPop() throws CollectionFullException, CollectionEmptyException {
    int testElement = 1;
    stack.push(testElement);
    assertEquals(testElement, stack.pop(), "ArrayStack.pop() is not returning the correct value.");
  }

  @Test
  public void testFullPush() throws CollectionFullException {
    for (int i = 0; i < SIZE; i++) {
      stack.push(i);
    }
    assertThrows(CollectionFullException.class, () -> stack.push(SIZE), "ArrayStack doesn't throw an exception when pushing onto a full Stack.");
  }

  @Test
  public void testEmptyPop() {
    assertThrows(CollectionEmptyException.class, stack::pop, "ArrayStack doesn't throw an exception when popping off of an empty Stack.");
  }

  @Test
  public void testEmptyPeek() {
    assertThrows(CollectionEmptyException.class, stack::peek, "ArrayStack doesn't throw an exception when peeking from an empty Stack.");
  }

  @Test
  public void testIsEmpty() {
    assertAll(
            () -> assertTrue(stack.isEmpty(), "ArrayStack.isEmpty() does not return true when no elements are present."),
            () -> {
              stack.push(0);
              assertFalse(stack.isEmpty(), "ArrayStack.isEmpty(0 returns true when elements are present.");
            }
    );
  }

  @Test
  public void testIsFull() {
    assertAll(
            () -> assertTrue(stack.isEmpty(), "ArrayStack.isEmpty() does not return true when no elements are present."),
            () -> {
              stack.push(0);
              assertFalse(stack.isEmpty(), "ArrayStack.isEmpty() returns true when elements are present.");
            }
    );
  }

  @Test
  public void testSize() {
    assertAll(
            () ->  {
              assertEquals(0, stack.size(), "An empty ArrayStack does not return a size of zero.");
            },
            () -> {
              stack.push(0);
              assertEquals(1, stack.size(), "ArrayStack size is not being calculated correctly.");
            },
            () -> {
              for (int i = 1; i < SIZE; i++) {
                stack.push(i);
              }
              assertEquals(SIZE, stack.size(), "ArrayStack size is not being calculated correctly.");
            }
    );
  }

  @Test
  public void testPushAndPopOrder() {
    int firstElement = 1;
    int secondElement = 2;
    int thirdElement = 3;
    String error = "ArrayStack does not preserve LIFO order when pushing and popping.";

    try {
      stack.push(firstElement);
      stack.push(secondElement);
      stack.push(thirdElement);
    } catch (CollectionFullException e) {
      e.printStackTrace();
    }

    assertAll(
            () -> assertEquals(thirdElement, stack.pop(), error),
            () -> assertEquals(secondElement, stack.pop(), error),
            () -> assertEquals(firstElement, stack.pop(), error)
    );
  }
}
