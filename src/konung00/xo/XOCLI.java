package konung00.xo;

import konung00.xo.model.Field;
import konung00.xo.model.Figure;
import konung00.xo.model.Game;
import konung00.xo.model.Player;
import konung00.xo.model.exceptions.InvalidPointException;
import konung00.xo.view.ConsoleView;

public class XOCLI {
    public static void main(final String[] args) throws InvalidPointException {
        final String name1 = "Gleb";
        final String name2 = "Slava";
        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);
        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)){
            consoleView.show(gameXO);
        }

    }
}
