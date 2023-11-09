package inlämningsuppgift;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TentaTest {

    @Test
    public void testCharactersCounter() {
        TextCounter counter = new TextCounter("tjäna");
        int totalChar = counter.charactersCounter();
        assertEquals(5, 5);

    }

    @Test
    public void testLinesCounter() {
        TextCounter counter = new TextCounter("Hej\nMitt namn är Nour\nVad heter du? ");
        int totaLines = counter.linesCounter();
        assertEquals(3, 3);

    }

    @Test
    public void testEmptyString() {

        TextCounter counter = new TextCounter("");

        int totalChar = counter.charactersCounter();

        assertEquals(0, totalChar);


    }


}





