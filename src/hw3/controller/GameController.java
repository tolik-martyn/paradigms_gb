package hw3.controller;

import hw3.model.Game;
import hw3.view.InputDevice;
import hw3.view.OutputDevice;

/**
 * Контроллер игры. Управляет логикой игры и взаимодействием с пользователем.
 */
public class GameController {
    private final Game game;
    private final InputDevice input;
    private final OutputDevice output;

    /**
     * Конструктор класса GameController.
     *
     * @param game   Игровая модель.
     * @param input  Устройство ввода данных.
     * @param output Устройство вывода данных.
     */
    public GameController(Game game, InputDevice input, OutputDevice output) {
        this.game = game;
        this.input = input;
        this.output = output;
    }

    /**
     * Запускает игру и управляет ею.
     */
    public void startGame() {
        do {
            output.showMessage("Новая игра:");
            game.initializeField();
            output.showTable(game.getTable());
            while (true) {
                output.showMessage("Ходит: " + game.getCurrentPlayer().getName());
                if (playerIsBot()) {
                    moveBot();
                } else {
                    movePlayer();
                }
                output.showTable(game.getTable());
                if (isWin()) {
                    output.showMessage("Победил: " + game.getCurrentPlayer().getName() + "!");
                    break;
                }
                if (isDraw()) {
                    output.showMessage("Ничья!");
                    break;
                }
                changeCurrentPlayer();
            }
            output.showMessage("Желаете сыграть еще раз? (Y - да)");
        } while (input.getUserData().equalsIgnoreCase("Y"));
    }

    /**
     * Выполняет ход игрока.
     */
    private void movePlayer() {
        int[] xAndY = input.getUserXAndY();
        if (isValidMove(xAndY)) {
            game.playerMove(xAndY);
        } else {
            output.showMessage("Некорректный ход. Попробуйте снова.");
            movePlayer();
        }
    }

    /**
     * Выполняет ход бота.
     */
    private void moveBot() {
        game.botMove();
    }

    /**
     * Проверяет, является ли ход игрока корректным.
     *
     * @param xAndY Массив с координатами хода (x, y).
     * @return true, если ход корректен, иначе false.
     */
    private boolean isValidMove(int[] xAndY) {
        return game.isValidMove(xAndY);
    }

    /**
     * Проверяет, наступила ли ничья в игре.
     *
     * @return true, если игра завершилась в ничью, иначе false.
     */
    private boolean isDraw() {
        return game.isDraw();
    }

    /**
     * Проверяет, выиграл ли текущий игрок.
     *
     * @return true, если текущий игрок выиграл, иначе false.
     */
    private boolean isWin() {
        return game.isWin();
    }

    /**
     * Сменяет текущего игрока.
     */
    private void changeCurrentPlayer() {
        game.changeCurrentPlayer();
    }

    private boolean playerIsBot(){
        return game.playerIsBot();
    }
}