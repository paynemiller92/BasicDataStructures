package com.paynemiller.datastructures.stack.application;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;
import com.paynemiller.datastructures.exception.math.UnrecognizedOperationException;
import com.paynemiller.datastructures.stack.Stack;

public class PostfixExpressionEvaluator {
  private final Stack<Integer> stack;

  public PostfixExpressionEvaluator(Stack<Integer> stack) {
    this.stack = stack;
  }

  public Integer evaluate(String expression) throws CollectionFullException, CollectionEmptyException {
    for (Character symbol : expression.toCharArray()) {
      try {
        Operator operator = Operator.fromCharacter(symbol);
        Integer a = stack.pop();
        Integer b = stack.pop();
        stack.push(operator.performOperation(a, b));
      } catch (UnrecognizedOperationException e) {
        Integer operand = parseSymbolAsOperand(symbol);
        stack.push(operand);
      }
    }
    return stack.pop();
  }

  private Integer parseSymbolAsOperand(Character symbol) {
    return Integer.parseInt(symbol.toString());
  }

  private enum Operator {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/'),
    MODULUS('%'),
    EXPONENTIATION('^');

    private final Character value;

    Operator(Character value) {
      this.value = value;
    }

    Integer performOperation(Integer a, Integer b) {
      return switch (this) {
        case ADDITION -> b + a;
        case SUBTRACTION -> b - a;
        case MULTIPLICATION -> b * a;
        case DIVISION -> b / a;
        case MODULUS -> b % a;
        case EXPONENTIATION -> Double.valueOf(Math.pow(b, a)).intValue();
      };
    }

    static Operator fromCharacter(Character character) throws UnrecognizedOperationException {
      for (Operator operator : values()) {
        if (operator.value.equals(character)) {
          return operator;
        }
      }
      throw new UnrecognizedOperationException();
    }
  }
}
