package hw3;

import hw3.controller.*;
import hw3.model.*;
import hw3.view.*;

public class Main {
    public static void main(String[] args) {
        int SIZE_X = 5;
        int SIZE_Y = 4;
        int WIN_COUNT = 3;

        Table table = new Table(SIZE_X, SIZE_Y, WIN_COUNT);
        Player player1 = new Player("Игрок", Symbol.CROSS);
        Player player2 = new Bot("Бот", Symbol.ZERO);

        InputDevice input = new ConsoleInput();
        OutputDevice output = new ConsoleOutput();

        Game game = new Game(table, player1, player2);
        GameController controller = new GameController(game, input, output);

        controller.startGame();
    }
}
