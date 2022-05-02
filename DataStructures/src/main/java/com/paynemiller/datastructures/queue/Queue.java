package com.paynemiller.datastructures.queue;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;

public interface Queue<T> {
  void enqueue(T value) throws CollectionFullException;
  T dequeue() throws CollectionEmptyException;
  T first() throws CollectionEmptyException;
  int size();
  boolean isEmpty();
}
