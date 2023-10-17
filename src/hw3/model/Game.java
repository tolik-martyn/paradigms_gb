package hw3.model;

import java.util.Random;

/**
 * Класс, представляющий игру в крестики-нолики.
 */
public class Game {
    private final Table table;
    private final Player player1;
    private final Player player2;
    private final Random random;
    private Player currentPlayer;

    /**
     * Создает новый экземпляр класса Game с указанными параметрами.
     *
     * @param table   Игровое поле (Table), на котором происходит игра.
     * @param player1 Первый игрок (Player).
     * @param player2 Второй игрок (Player).
     */
    public Game(Table table, Player player1, Player player2) {
        this.table = table;
        this.player1 = player1;
        this.player2 = player2;
        this.random = new Random();
        this.currentPlayer = random.nextBoolean() ? this.player1 : this.player2;
    }

    /**
     * Возвращает текущее игровое поле (Table).
     *
     * @return Текущее игровое поле.
     */
    public Table getTable() {
        return table;
    }

    /**
     * Возвращает текущего игрока (Player), который сейчас делает ход.
     *
     * @return Текущий игрок.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Проверяет, является ли заданный ход (координаты x и y) допустимым.
     *
     * @param xAndY Массив с координатами хода (x, y).
     * @return true, если ход допустим, иначе false.
     */
    public boolean isValidMove(int[] xAndY) {
        return table.isValidMove(xAndY);
    }

    /**
     * Проверяет, наступила ли ничья в игре.
     *
     * @return true, если игра завершилась в ничью, иначе false.
     */
    public boolean isDraw() {
        return table.isDraw();
    }

    /**
     * Проверяет, выиграл ли текущий игрок.
     *
     * @return true, если текущий игрок выиграл, иначе false.
     */
    public boolean isWin() {
        return table.isWin(currentPlayer.getSymbol());
    }

    /**
     * Сменяет текущего игрока.
     */
    public void changeCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /**
     * Выполняет ход бота.
     */
    public void botMove() {
        Point[] field = table.getField();
        while (true) {
            int index = random.nextInt(field.length);
            Point selectedPoint = field[index];
            if (selectedPoint.getSymbol() == Symbol.EMPTY) {
                selectedPoint.setSymbol(currentPlayer.getSymbol());
                break;
            }
        }
    }

    /**
     * Выполняет ход игрока.
     *
     * @param xAndY Массив с координатами хода (x, y).
     */
    public void playerMove(int[] xAndY) {
        Point[] field = table.getField();
        int index = xAndY[1] * table.getSIZE_X() + xAndY[0];
        field[index].setSymbol(currentPlayer.getSymbol());
    }

    /**
     * Инициализирует игровое поле, сбрасывая его в начальное состояние.
     */
    public void initializeField() {
        table.initializeField();
    }
}