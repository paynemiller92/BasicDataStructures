package com.paynemiller.datastructures.list;

import org.junit.jupiter.api.BeforeEach;

public class DoublyLinkedListTest extends LinkedListTest {
  private static final int LIST_SIZE = 5;

  @BeforeEach
  @Override
  public void setup() {
    list = new DoublyLinkedList<>(LIST_SIZE);
  }
}
