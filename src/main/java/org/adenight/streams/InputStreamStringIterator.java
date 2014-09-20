package org.adenight.streams;

import com.google.common.collect.AbstractIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamStringIterator extends AbstractIterator<String> {

    private final BufferedReader bufferedReader;

    public InputStreamStringIterator(InputStream inputStream) {
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        this.bufferedReader = new BufferedReader(streamReader);
    }

    @Override
    protected String computeNext() {
        try {
            String next = bufferedReader.readLine();
            if(next == null){
                bufferedReader.close();
                return endOfData();
            }
            return next;
        } catch (IOException e) {
            throw new RuntimeException("Can not read data", e);
        }
    }
}
