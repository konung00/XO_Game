package konung00.xo.controller;

import konung00.xo.model.Field;
import konung00.xo.model.Figure;
import konung00.xo.model.exceptions.InvalidPointException;
import konung00.xo.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws InvalidPointException, PointAlreadyOccupiedException{
        if (field.getFigure(point) != null){
            throw new PointAlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }
}
