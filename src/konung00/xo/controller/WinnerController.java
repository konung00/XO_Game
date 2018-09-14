package konung00.xo.controller;

import konung00.xo.model.Field;
import konung00.xo.model.Figure;
import konung00.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            // Horizontal Checking
//            for (int i = 0; i < 3; i++) {
//                if (checkThreeCoordinates(field, new Point(i, 0), new IPointGenerator() {
//                    @Override
//                    public Point next(Point p) {
//                        return new Point(p.x, p.y + 1);
//                    }
//                }))
//                    return field.getFigure(new Point(i, 0));
//            }

            for (int i = 0; i < 3; i++) {
                if (checkThreeCoordinates(field, new Point(i, 0), p -> new Point(p.x, p.y+1)))
                return field.getFigure(new Point(i,0));
        }


                        // Vertical Checking
//            for (int i = 0; i < 3; i++) {
//                if (checkThreeCoordinates(field, new Point(0, i), new IPointGenerator() {
//                    @Override
//                    public Point next(Point p) {
//                        return new Point(p.x+1, p.y);
//                    }
//                }))
//                    return field.getFigure(new Point(0, i));
//            }

            for (int i = 0; i < 3; i++) {
                if (checkThreeCoordinates(field, new Point(0, i), p -> new Point(p.x+1, p.y)))
                    return field.getFigure(new Point(0,i));
            }

            // Diagonal Checking
//            for (int i = 0; i < 3; i++) {
//                if (checkThreeCoordinates(field, new Point(0, 0), new IPointGenerator() {
//                    @Override
//                    public Point next(Point p) {
//                        return new Point(p.x+1, p.y+1);
//                    }
//                }))
//                    return field.getFigure(new Point(0, 0));
//            }

            for (int i = 0; i < 3; i++) {
                if (checkThreeCoordinates(field, new Point(0, 0), p -> new Point(p.x+1, p.y+1)))
                    return field.getFigure(new Point(0,0));
            }


            // Diagonal Checking (visa versa)
//            for (int i = 0; i < 3; i++) {
//                if (checkThreeCoordinates(field, new Point(0, 2), new IPointGenerator() {
//                    @Override
//                    public Point next(Point p) {
//                        return new Point(p.x+1, p.y-1);
//                    }
//                }))
//                    return field.getFigure(new Point(0, 2));
//            }
            for (int i = 0; i < 3; i++) {
                if (checkThreeCoordinates(field, new Point(0, 2), p -> new Point(p.x+1, p.y-1)))
                    return field.getFigure(new Point(0,2));
            }

        } catch (InvalidPointException e){
            e.printStackTrace();
        } return null;
    }

    private boolean checkThreeCoordinates(final Field field,
                                          final Point currentPoint,
                                          final IPointGenerator pointGenerator){
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);
        } catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) return false;

        if (currentFigure != nextFigure) return false;

        return checkThreeCoordinates(field, nextPoint, pointGenerator);
    }

    private static interface IPointGenerator {
        Point next(Point p);
    }
}
