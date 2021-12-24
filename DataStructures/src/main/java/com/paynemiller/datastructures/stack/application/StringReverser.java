package com.paynemiller.datastructures.stack.application;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;
import com.paynemiller.datastructures.stack.ArrayStack;
import com.paynemiller.datastructures.stack.Stack;

public class StringReverser {
  public String reverse(String string) {
    char[] letters = string.toCharArray();
    StringBuilder reversedStringBuilder = new StringBuilder();
    Stack<Character> letterStack = new ArrayStack<>(Character.class, letters.length);
    for (char letter: letters) {
      try {
        letterStack.push(letter);
      } catch (CollectionFullException e) {
        e.printStackTrace();
      }
    }

    while (!letterStack.isEmpty()) {
      try {
        reversedStringBuilder.append(letterStack.pop());
      } catch (CollectionEmptyException e) {

        e.printStackTrace();
      }
    }
    return reversedStringBuilder.toString();
  }
}
