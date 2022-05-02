package com.paynemiller.datastructures.queue;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {
  private static final int QUEUE_SIZE = 5;
  private static final int FIRST_ELEMENT = 1;
  private static final int SECOND_ELEMENT = 2;
  private static final String QUEUE_EMPTY_ERROR = "Queue is empty!";
  private static final String QUEUE_FULL_ERROR = "Queue is full!";

  private Queue<Integer> queue;

  @BeforeEach
  public void setup() {
    queue = new ArrayQueue<>(QUEUE_SIZE);
  }

  @Test
  public void testEnqueueAndDequeue() {
    try {
      queue.enqueue(FIRST_ELEMENT);
      assertEquals(FIRST_ELEMENT, queue.dequeue());
    } catch (CollectionFullException e) {
      fail();
    } catch (CollectionEmptyException e) {
      fail(QUEUE_EMPTY_ERROR);
    }
  }

  @Test
  public void testIsEmpty() {
    try {
      assertTrue(queue.isEmpty());
      queue.enqueue(FIRST_ELEMENT);
      assertFalse(queue.isEmpty());
    } catch (CollectionFullException e) {
      fail(QUEUE_FULL_ERROR);
    }
  }

  @Test
  public void testSize() {
    try {
      queue.enqueue(FIRST_ELEMENT);
      assertEquals(1, queue.size(), "Queue size is not being reported correctly with a single element in the Queue.");
      queue.enqueue(SECOND_ELEMENT);
      assertEquals(2, queue.size(), "Queue size is not being reported correctly with multiple elements in the Queue.");
    } catch (CollectionFullException e) {
      fail(QUEUE_FULL_ERROR);
    }
  }

  @Test
  public void testFirst() {
    try {
      queue.enqueue(FIRST_ELEMENT);
      assertEquals(FIRST_ELEMENT, queue.first());
      queue.enqueue(SECOND_ELEMENT);
      assertEquals(FIRST_ELEMENT, queue.first());
    } catch (CollectionEmptyException e) {
      fail(QUEUE_EMPTY_ERROR);
    } catch (CollectionFullException e) {
      fail(QUEUE_FULL_ERROR);
    }
  }
}
