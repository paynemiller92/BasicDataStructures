package com.paynemiller.datastructures.stack.application;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;
import com.paynemiller.datastructures.stack.ArrayStack;
import com.paynemiller.datastructures.stack.Stack;

public class StringReverser {
  private final Stack<Character> letterStack;

  public StringReverser(Stack<Character> letterStack) {
    this.letterStack = letterStack;
  }

  public String reverse(String string) {
    char[] letters = string.toCharArray();
    StringBuilder reversedStringBuilder = new StringBuilder();
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
