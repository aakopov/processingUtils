package org.adenight.operators;

import java.io.Closeable;

public interface Operator<T> extends Closeable{

    public void apply(T input);
}
