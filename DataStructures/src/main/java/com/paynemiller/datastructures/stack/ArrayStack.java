package com.paynemiller.datastructures.stack;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;

import java.lang.reflect.Array;

public class ArrayStack<T> implements Stack<T> {
  private final int size;
  private final T[] elements;
  private int top;

  public ArrayStack(Class<T> clazz, int size) {
    this.size = size;
    this.top = size;
    this.elements = (T[]) Array.newInstance(clazz, size);
  }

  @Override
  public void push(T element) throws CollectionFullException {
    if (this.isFull()) {
      throw new CollectionFullException();
    }
    top--;
    elements[top] = element;
  }

  @Override
  public T pop() throws CollectionEmptyException {
    if (this.isEmpty()) {
      throw new CollectionEmptyException();
    }
    T poppedTop = elements[top];
    elements[top] = null;
    top++;
    return poppedTop;
  }

  @Override
  public T peek() throws CollectionEmptyException {
    if (this.isEmpty()) {
      throw new CollectionEmptyException();
    }
    return elements[top];
  }

  @Override
  public boolean isFull() {
    return top == 0;
  }

  @Override
  public boolean isEmpty() {
    return top == size;
  }

  @Override
  public int size() {
    return this.size - top;
  }
}
