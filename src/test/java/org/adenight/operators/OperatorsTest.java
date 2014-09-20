package org.adenight.operators;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import org.adenight.utils.TestOperator;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class OperatorsTest {

    @Test
    public void testWithOneOperatorAndIterator(){
        Iterator<Integer> input = Iterators.forArray(1,2,3);
        TestOperator operator = new TestOperator();
        Operators.process(input, operator);

        List<Integer> expectedResult = Lists.newArrayList(1,2,3);
        assertEquals(expectedResult, operator.getResult());
        assertEquals(3, operator.getIndex());
        assertTrue(operator.isWasClosed());
    }

    @Test
    public void testWithMultipleOperatorsAndIterator(){
        Iterator<Integer> input = Iterators.forArray(1,2,3);
        TestOperator operator1 = new TestOperator();
        TestOperator operator2 = new TestOperator();
        Operators.process(input, operator1, operator2);

        List<Integer> expectedResult = Lists.newArrayList(1,2,3);
        assertEquals(expectedResult, operator1.getResult());
        assertEquals(3, operator1.getIndex());
        assertTrue(operator1.isWasClosed());

        assertEquals(expectedResult, operator2.getResult());
        assertEquals(3, operator2.getIndex());
        assertTrue(operator2.isWasClosed());
    }

    @Test
    public void testWithOneOperatorAndIterable(){
        List<Integer> input = Lists.newArrayList(1,2,3);
        TestOperator operator = new TestOperator();
        Operators.process(input, operator);

        List<Integer> expectedResult = Lists.newArrayList(1,2,3);
        assertEquals(expectedResult, operator.getResult());
        assertEquals(3, operator.getIndex());
        assertTrue(operator.isWasClosed());
    }

    @Test
    public void testWithMultipleOperatorAndIterable(){
        List<Integer> input = Lists.newArrayList(1,2,3);
        TestOperator operator1 = new TestOperator();
        TestOperator operator2 = new TestOperator();
        Operators.process(input, operator1, operator2);

        List<Integer> expectedResult = Lists.newArrayList(1,2,3);
        assertEquals(expectedResult, operator1.getResult());
        assertEquals(3, operator1.getIndex());
        assertTrue(operator1.isWasClosed());

        assertEquals(expectedResult, operator2.getResult());
        assertEquals(3, operator2.getIndex());
        assertTrue(operator2.isWasClosed());
    }

}
