package org.adenight.streams;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class InputStreamStringIteratorTest {

    @Test
    public void testReading(){
        InputStream input = InputStreamStringIteratorTest.class.getResourceAsStream("/data");
        assertNotNull(input);
        InputStreamStringIterator iterator = new InputStreamStringIterator(input);

        assertEquals("First", iterator.next());
        assertEquals("Second", iterator.next());
        assertFalse(iterator.hasNext());
    }

}
