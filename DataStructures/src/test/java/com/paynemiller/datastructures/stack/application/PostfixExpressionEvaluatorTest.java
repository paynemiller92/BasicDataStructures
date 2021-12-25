package com.paynemiller.datastructures.stack.application;

import com.paynemiller.datastructures.exception.CollectionEmptyException;
import com.paynemiller.datastructures.exception.CollectionFullException;
import com.paynemiller.datastructures.stack.ArrayStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PostfixExpressionEvaluatorTest {
  private static final String EXPRESSION = "53+82-*";
  private static final Integer EXPECTED_RESULT = 48;

  @Test
  public void testEvaluation() {
    PostfixExpressionEvaluator evaluator = new PostfixExpressionEvaluator(new ArrayStack<>(Integer.class, EXPRESSION.length()));
    try {
      assertEquals(EXPECTED_RESULT, evaluator.evaluate(EXPRESSION));
    } catch (CollectionFullException | CollectionEmptyException e) {
      fail("PostfixExpressionEvaluator is throwing Collection exceptions! Is it configured properly?");
    }
  }
}
