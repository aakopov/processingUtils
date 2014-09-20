package org.adenight.operators;

import java.io.IOException;
import java.util.Iterator;

public class Operators {

    public static <T> void process(Iterator<T> iterator, Operator<T>... operators){
        while (iterator.hasNext()){
            T next = iterator.next();
            for(Operator<T> o : operators){
                o.apply(next);
            }
        }
        for(Operator<T> o : operators){
            try {
                o.close();
            } catch (IOException e) {
                throw new RuntimeException("Operator closing error", e);
            }
        }
    }

    public static <T> void process(Iterable<T> iterable, Operator<T>... operators){
        process(iterable.iterator(), operators);
    }
}
