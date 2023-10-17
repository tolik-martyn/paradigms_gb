package hw3.model;

/**
 * Класс, представляющий игровое поле для игры в крестики-нолики.
 */
public class Table {
    private final Point[] field;
    private final int SIZE_X;
    private final int SIZE_Y;
    private final int WIN_COUNT;

    /**
     * Создает новый экземпляр класса Table с указанными параметрами.
     *
     * @param sizeX    Размер игрового поля по горизонтали (количество столбцов).
     * @param sizeY    Размер игрового поля по вертикали (количество строк).
     * @param winCount Количество символов подряд, необходимых для победы.
     */
    public Table(int sizeX, int sizeY, int winCount) {
        this.SIZE_X = sizeX;
        this.SIZE_Y = sizeY;
        this.WIN_COUNT = winCount;
        field = new Point[SIZE_X * SIZE_Y];
    }

    /**
     * Инициализирует игровое поле, сбрасывая его в начальное состояние (все точки пустые).
     */
    public void initializeField() {
        for (int i = 0; i < field.length; i++) {
            field[i] = new Point(Symbol.EMPTY);
        }
    }

    /**
     * Возвращает массив точек, представляющих игровое поле.
     *
     * @return Массив точек (Point[]).
     */
    public Point[] getField() {
        return field;
    }

    /**
     * Возвращает размер игрового поля по горизонтали.
     *
     * @return Размер поля по горизонтали.
     */
    public int getSIZE_X() {
        return SIZE_X;
    }

    /**
     * Возвращает размер игрового поля по вертикали.
     *
     * @return Размер поля по вертикали.
     */
    public int getSIZE_Y() {
        return SIZE_Y;
    }

    /**
     * Проверяет, является ли указанный ход (координаты x и y) допустимым.
     *
     * @param xAndY Массив с координатами хода (x, y).
     * @return true, если ход допустим, иначе false.
     */
    public boolean isValidMove(int[] xAndY) {
        int x = xAndY[0];
        int y = xAndY[1];

        // Проверим, что x и y находятся в допустимых пределах
        if (x >= 0 && x < SIZE_X && y >= 0 && y < SIZE_Y) {
            int index = y * SIZE_X + x;
            return field[index].getSymbol() == Symbol.EMPTY;
        } else {
            return false; // Координаты выходят за пределы поля
        }
    }

    /**
     * Проверяет, наступила ли ничья на игровом поле.
     *
     * @return true, если игра завершилась в ничью, иначе false.
     */
    public boolean isDraw() {
        for (Point point : field) {
            if (point.getSymbol() == Symbol.EMPTY) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет, выиграл ли какой-либо игрок с указанным символом.
     *
     * @param symbol Символ игрока (Symbol), который проверяется на победу.
     * @return true, если игрок с указанным символом выиграл, иначе false.
     */
    public boolean isWin(Symbol symbol) {

        // Проверка по горизонтали
        for (int y = 0; y < SIZE_Y; y++) {
            int count = 0;
            for (int x = 0; x < WIN_COUNT; x++) {
                int index = y * SIZE_X + x;
                if (field[index].getSymbol() == symbol) {
                    count++;
                }
            }
            if (count == WIN_COUNT) {
                return true;
            }
        }

        // Проверка по вертикали
        for (int x = 0; x < SIZE_X; x++) {
            int count = 0;
            for (int y = 0; y < WIN_COUNT; y++) {
                int index = y * SIZE_X + x;
                if (field[index].getSymbol() == symbol) {
                    count++;
                }
            }
            if (count == WIN_COUNT) {
                return true;
            }
        }

        // Проверка по диагоналям
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < WIN_COUNT; i++) {
            int index1 = i * SIZE_X + i;
            int index2 = i * SIZE_X + (SIZE_X - 1 - i);

            if (field[index1].getSymbol() == symbol) {
                count1++;
            }
            if (field[index2].getSymbol() == symbol) {
                count2++;
            }
        }
        return count1 == WIN_COUNT || count2 == WIN_COUNT;
    }
}