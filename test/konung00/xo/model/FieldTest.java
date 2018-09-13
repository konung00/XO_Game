package konung00.xo.model;

import konung00.xo.model.exceptions.InvalidPointException;
import konung00.xo.model.exceptions.PointAlreadyOccupiedException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetSize() {
        final Field field = new Field(3);

        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);
        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);
        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() {
        final Field field = new Field(3);
        final Point inputPoint = new Point(-1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void testGetFigureWhenYIsLessThenZero() {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,-1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.getSize()+1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,field.getSize()+1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

}