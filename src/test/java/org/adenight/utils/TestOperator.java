package org.adenight.utils;

import com.google.common.collect.Lists;
import org.adenight.operators.Operator;

import java.io.IOException;
import java.util.List;

public class TestOperator implements Operator<Integer> {
    private int index = 0;
    private List<Integer> result;
    private boolean wasClosed = false;

    public TestOperator(){
        result = Lists.newArrayList();
    }

    @Override
    public void apply(Integer input) {
        result.add(index, input);
        index++;
    }

    @Override
    public void close() throws IOException{
        wasClosed = true;
    }

    public int getIndex() {
        return index;
    }

    public List<Integer> getResult() {
        return result;
    }

    public boolean isWasClosed() {
        return wasClosed;
    }
}
