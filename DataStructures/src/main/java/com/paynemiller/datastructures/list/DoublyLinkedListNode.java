package com.paynemiller.datastructures.list;

import com.paynemiller.datastructures.common.Node;

public class DoublyLinkedListNode<T> extends Node<T> {
  private DoublyLinkedListNode<T> next;
  private DoublyLinkedListNode<T> previous;

  public DoublyLinkedListNode(T value) {
    super(value);
  }

  public DoublyLinkedListNode<T> getNext() {
    return next;
  }

  public DoublyLinkedListNode<T> setNext(DoublyLinkedListNode<T> next) {
    this.next = next;
    return this;
  }

  public DoublyLinkedListNode<T> getPrevious() {
    return previous;
  }

  public DoublyLinkedListNode<T> setPrevious(DoublyLinkedListNode<T> previous) {
    this.previous = previous;
    return this;
  }
}
