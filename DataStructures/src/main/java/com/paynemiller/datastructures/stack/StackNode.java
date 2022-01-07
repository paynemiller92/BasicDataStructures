package com.paynemiller.datastructures.stack;

import com.paynemiller.datastructures.common.Node;

public class StackNode<T> extends Node<T> {
  private StackNode<T> next;

  public StackNode(T value) {
    super(value);
  }

  public void setNext(StackNode<T> next) {
    this.next = next;
  }

  public StackNode<T> getNext() {
    return next;
  }
}
