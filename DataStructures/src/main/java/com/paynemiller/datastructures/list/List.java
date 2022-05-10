package com.paynemiller.datastructures.list;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;

public interface List<T> {
  void add(T element) throws CollectionFullException;
  T remove() throws CollectionEmptyException;
  T first();
  T last();
  boolean contains(T value);
  boolean isFull();
  boolean isEmpty();
  int size();
}
