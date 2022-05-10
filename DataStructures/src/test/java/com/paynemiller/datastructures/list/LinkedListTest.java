package com.paynemiller.datastructures.list;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
  private static final int LIST_SIZE = 5;
  private static final int FIRST_ELEMENT = 1;
  private static final int SECOND_ELEMENT = 2;
  private static final int THIRD_ELEMENT = 3;
  private static final String LIST_FULL_ERROR = "The List is full! Please check your configuration.";
  private static final String LIST_EMPTY_ERROR = "The list is empty! Please check your configuration.";

  List<Integer> list;

  @BeforeEach
  public void setup() {
    list = new LinkedList<>(LIST_SIZE);
  }

  @Test
  public void testAdd() {
    try {
      list.add(FIRST_ELEMENT);
      assertTrue(list.contains(FIRST_ELEMENT));
      assertEquals(FIRST_ELEMENT, list.first());
      assertEquals(FIRST_ELEMENT, list.last());

      list.add(SECOND_ELEMENT);
      assertTrue(list.contains(SECOND_ELEMENT));
      assertEquals(FIRST_ELEMENT, list.first());
      assertEquals(SECOND_ELEMENT, list.last());

      list.add(THIRD_ELEMENT);
      assertTrue(list.contains(THIRD_ELEMENT));
      assertEquals(FIRST_ELEMENT, list.first());
      assertEquals(THIRD_ELEMENT, list.last());
    } catch (CollectionFullException e) {
      fail(LIST_FULL_ERROR);
    }
  }

  @Test
  public void testRemove() {
    populateList();
    int removedElement = 0;
    try {
      removedElement = this.list.remove();
    } catch (CollectionEmptyException e) {
      fail(LIST_EMPTY_ERROR);
    }
    assertEquals(FIRST_ELEMENT, removedElement);
    assertFalse(list.contains(FIRST_ELEMENT));
    assertEquals(LIST_SIZE - 1, list.size());
  }

  @Test
  public void testIsEmpty() {
    assertTrue(list.isEmpty());
    try {
      list.add(FIRST_ELEMENT);
      assertFalse(list.isEmpty());
      list.remove();
    } catch (CollectionEmptyException e) {
      fail(LIST_EMPTY_ERROR);
    } catch (CollectionFullException e) {
      fail(LIST_FULL_ERROR);
    }
    assertTrue(list.isEmpty());
  }

  @Test
  public void testIsFull() {
    assertFalse(list.isFull());
    try {
      populateList();
      assertTrue(list.isFull());
      list.remove();
      assertFalse(list.isFull());
    } catch (CollectionEmptyException e) {
      fail(LIST_EMPTY_ERROR);
    }
    assertFalse(list.isFull());
  }

  private void populateList() {
    try {
      for (int index = 1; index < LIST_SIZE + 1; index++) {
        this.list.add(index);
      }
    } catch (CollectionFullException e) {
      fail(LIST_FULL_ERROR);
    }
  }
}
