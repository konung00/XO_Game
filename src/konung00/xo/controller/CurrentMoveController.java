package konung00.xo.controller;

import konung00.xo.model.Field;
import konung00.xo.model.Figure;
import konung00.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) throws InvalidPointException {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++){
            countFigure += countFigureInTheColumn(field, x);
            }
        if (countFigure == field.getSize() * field.getSize()){
            return null;
        }
        if (countFigure % 2 == 0){
            return Figure.X;
        }
        return Figure.O;
    }

    private int countFigureInTheColumn(final Field field, int row) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null) {
                    countFigure++;
                }
            } catch (final InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }
}
