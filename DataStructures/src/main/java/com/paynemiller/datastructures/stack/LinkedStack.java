package com.paynemiller.datastructures.stack;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;

public class LinkedStack<T> implements Stack<T> {
  private StackNode<T> top;
  private final int maximumSize;

  public LinkedStack(int maximumSize) {
    this.maximumSize = maximumSize;
  }

  @Override
  public void push(T element) throws CollectionFullException {
    StackNode<T> newNode = new StackNode<>(element);
    if (top == null) {
      top = newNode;
    } else {
      if (size() < maximumSize) {
        newNode.setNext(this.top);
        top = newNode;
      } else {
        throw new CollectionFullException();
      }
    }
  }

  @Override
  public T pop() throws CollectionEmptyException {
    T topValue = peek();
    top = top.getNext();
    return topValue;
  }

  @Override
  public T peek() throws CollectionEmptyException {
    if (isEmpty()) {
      throw new CollectionEmptyException();
    }
    return top.getValue();
  }

  @Override
  public boolean isFull() {
    int numberOfElements = 0;
    StackNode<T> currentNode = top;
    while (currentNode != null) {
      numberOfElements++;
      currentNode = currentNode.getNext();
    }
    return numberOfElements >= this.maximumSize;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    StackNode<T> currentNode = top;
    int level = 0;
    while (currentNode != null) {
      currentNode = currentNode.getNext();
      level++;
    }
    return level;
  }
}
