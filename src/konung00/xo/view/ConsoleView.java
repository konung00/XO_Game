package konung00.xo.view;

import konung00.xo.controller.CurrentMoveController;
import konung00.xo.controller.MoveController;
import konung00.xo.controller.WinnerController;
import konung00.xo.model.Field;
import konung00.xo.model.Figure;
import konung00.xo.model.Game;
import konung00.xo.model.exceptions.InvalidPointException;
import konung00.xo.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game){
        System.out.format("Game name %s\n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++){
            if (x != 0){
                printSeparator();
            }
            printLine(field, x);
        }
    }

    public boolean move(final Game game) throws InvalidPointException {
        final Field field = game.getField();

        final Figure winner = winnerController.getWinner(field);
        if (winner != null){
            System.out.format("Winner is: %s!\n", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null){
            System.out.println("No winner and no moves left!");
            return false;
        }
        System.out.format("Please enter a move point for: %s. ", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field,currentFigure,point);
        } catch (final PointAlreadyOccupiedException e) {
            System.out.println("Point is invalid");
        }
        return true;
    }

    private Point askPoint(){
        return new Point(askCoordinate("X") -1, askCoordinate("Y") -1);
    }

    private int askCoordinate(final String coordinateName){
        System.out.format("Please input %s :", coordinateName);
        final Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (final InputMismatchException e){
            System.out.println("Are you sure?! ");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field field, final int x) {
        for (int y = 0; y < field.getSize(); y++){
            if (y != 0){
                System.out.print("|");
            }
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator(){
        System.out.println("~~~~~~~~~~~");
    }
}
