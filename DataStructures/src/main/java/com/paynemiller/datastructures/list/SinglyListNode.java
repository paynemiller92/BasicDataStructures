package com.paynemiller.datastructures.list;

import com.paynemiller.datastructures.common.Node;

public class SinglyListNode<T> extends Node<T> {
  private SinglyListNode<T> next;

  public SinglyListNode(T value) {
    super(value);
    this.next = null;
  }

  public SinglyListNode<T> getNext() {
    return next;
  }

  public void setNext(SinglyListNode<T> next) {
    this.next = next;
  }
}
