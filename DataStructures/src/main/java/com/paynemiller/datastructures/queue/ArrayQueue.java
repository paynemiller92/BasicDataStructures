package com.paynemiller.datastructures.queue;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;

import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> {

  private final int maxCapacity;
  private T[] elements;
  private int rearPosition;

  public ArrayQueue(int maxCapacity) {
    this.maxCapacity = maxCapacity;
    this.rearPosition = 0;
    this.elements = (T[]) new Object[maxCapacity];
  }

  @Override
  public void enqueue(T value) throws CollectionFullException {
    if (size() == maxCapacity) {
      throw new CollectionFullException();
    } else {
      elements[rearPosition] = value;
      rearPosition++;
    }
  }

  @Override
  public T dequeue() throws CollectionEmptyException {
    if (isEmpty()) {
      throw new CollectionEmptyException();
    } else {
      T returnValue = this.elements[0];
      this.shiftQueueForward();
      return returnValue;
    }
  }

  @Override
  public T first() throws CollectionEmptyException {
    if (isEmpty()) {
      throw new CollectionEmptyException();
    }
    return this.elements[0];
  }

  @Override
  public int size() {
    return this.rearPosition;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  public int getRearPosition() {
    return rearPosition;
  }

  private void shiftQueueForward() {
    this.elements = Arrays.copyOfRange(this.elements, 1, rearPosition);
    rearPosition--;
  }
}
