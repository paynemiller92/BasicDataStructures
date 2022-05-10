package com.paynemiller.datastructures.list;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;

public class LinkedList<T> implements List<T> {
  private final int maxSize;
  private SinglyListNode<T> firstElement;

  public LinkedList(int capacity) {
    this.maxSize = capacity;
  }

  @Override
  public void add(T element) throws CollectionFullException {
    if (size() == maxSize) {
      throw new CollectionFullException();
    } else {
      SinglyListNode<T> newNode = new SinglyListNode<>(element);
      if (isEmpty()) {
        this.firstElement = newNode;
      } else {
        findLastElement().setNext(newNode);
      }
    }
  }

  @Override
  public T remove() throws CollectionEmptyException {
    if (this.isEmpty()) {
      throw new CollectionEmptyException();
    }
    T removedElement = this.firstElement.getValue();
    this.firstElement = firstElement.getNext();
    return removedElement;
  }

  @Override
  public T first() {
    return this.firstElement.getValue();
  }

  @Override
  public T last() {
    return this.findLastElement().getValue();
  }

  @Override
  public boolean contains(T value) {
    SinglyListNode<T> traversalNode = firstElement;
    while (traversalNode != null) {
      if (traversalNode.getValue().equals(value)) {
        return true;
      }
      traversalNode = traversalNode.getNext();
    }
    return false;
  }

  @Override
  public boolean isFull() {
    return size() == this.maxSize;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    SinglyListNode<T> traversalNode = firstElement;
    int size = 0;
    while (traversalNode != null) {
      size++;
      traversalNode = traversalNode.getNext();
    }
    return size;
  }

  private SinglyListNode<T> findLastElement() {
    SinglyListNode<T> traversalNode = this.firstElement;
    while (traversalNode.getNext() != null) {
      traversalNode = traversalNode.getNext();
    }
    return traversalNode;
  }
}
