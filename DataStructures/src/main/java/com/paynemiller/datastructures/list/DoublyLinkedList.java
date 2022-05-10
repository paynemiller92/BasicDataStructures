package com.paynemiller.datastructures.list;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;

public class DoublyLinkedList<T> implements List<T> {
  private final int maxSize;
  private DoublyLinkedListNode<T> firstElement;

  public DoublyLinkedList(int capacity) {
    this.maxSize = capacity;
  }

  @Override
  public void add(T element) throws CollectionFullException {
    if (size() == this.maxSize) {
      throw new CollectionFullException();
    }
    DoublyLinkedListNode<T> newElement = new DoublyLinkedListNode<>(element);
    if (this.firstElement == null) {
      this.firstElement = newElement;
    } else {
      DoublyLinkedListNode<T> lastElement = findLastElement();
      newElement.setPrevious(lastElement);
      lastElement.setNext(newElement);
    }
  }

  @Override
  public T remove() throws CollectionEmptyException {
    if (isEmpty()) {
      throw new CollectionEmptyException();
    }
    T removedValue = first();
    this.firstElement = firstElement.getNext();
    if (firstElement != null) {
      this.firstElement.setPrevious(null);
    }
    return removedValue;
  }

  @Override
  public T first() {
    return this.firstElement.getValue();
  }

  @Override
  public T last() {
    return findLastElement().getValue();
  }

  @Override
  public boolean contains(T value) {
    DoublyLinkedListNode<T> traversalNode = this.firstElement;
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
    DoublyLinkedListNode<T> traversalNode = this.firstElement;
    int size = 0;
    while (traversalNode != null) {
      size++;
      traversalNode = traversalNode.getNext();
    }
    return size;
  }

  private DoublyLinkedListNode<T> findLastElement() {
    DoublyLinkedListNode<T> traversalNode = this.firstElement;
    while (traversalNode.getNext() != null) {
      traversalNode = traversalNode.getNext();
    }
    return traversalNode;
  }
}
