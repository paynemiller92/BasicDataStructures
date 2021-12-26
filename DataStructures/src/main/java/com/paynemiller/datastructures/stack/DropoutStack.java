package com.paynemiller.datastructures.stack;

import com.paynemiller.datastructures.exception.CollectionEmptyException;

import java.util.Arrays;
import java.util.Objects;

public class DropoutStack<T> implements Stack<T> {
  int top;
  T[] elements;

  public DropoutStack(int size) {
    this.top = 0;
    this.elements = (T[]) new Object[size];
  }

  @Override
  public void push(T element) {
    top++;
    elements[top % elements.length] = element;
  }

  @Override
  public T pop() throws CollectionEmptyException {
    if (isEmpty()) {
      throw new CollectionEmptyException();
    }
    T poppedValue = elements[top % elements.length];
    elements[top % elements.length] = null;
    top--;
    return poppedValue;
  }

  @Override
  public T peek() throws CollectionEmptyException {
    if (isEmpty()) {
      throw new CollectionEmptyException();
    }
    return elements[top % elements.length];
  }

  @Override
  public boolean isFull() {
    return size() == elements.length;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    return (int) Arrays.stream(elements)
            .filter(Objects::nonNull)
            .count();
  }
}
