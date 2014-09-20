package org.adenight.streams;

import org.adenight.operators.Operator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamStringOperator implements Operator<String>{

    private final BufferedWriter bufferedWriter;

    public OutputStreamStringOperator(OutputStream outputStream) {
        OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
        this.bufferedWriter = new BufferedWriter(streamWriter);
    }

    @Override
    public void apply(String input) {
        try {
            bufferedWriter.append(input);
        } catch (IOException e) {
            throw new RuntimeException("Error while writing", e);
        }
    }

    @Override
    public void close() throws IOException {
        bufferedWriter.close();
    }
}
