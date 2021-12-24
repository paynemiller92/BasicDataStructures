package com.paynemiller.datastructures.stack;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;

public interface Stack<T> {
  void push(T element) throws CollectionFullException;
  T pop() throws CollectionEmptyException;
  T peek() throws CollectionEmptyException;
  boolean isFull();
  boolean isEmpty();
  int size();
}
