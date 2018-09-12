package konung00.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() throws Exception {

        final String inputValue = "Slava";
        final String expectedValue = "Slava";

        final Player player = new Player(inputValue, null);
        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getFigure() throws Exception {

        final Figure inputValue = Figure.X;
        final Figure expectedValue = Figure.X;

        final Player player = new Player("Slava", inputValue);
        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);
    }
}