package hw3.model;

public class Point {

    /**
     * Класс, представляющий отдельную точку на игровом поле.
     */
    private Symbol symbol;

    /**
     * Создает новый экземпляр класса Point с указанным символом.
     *
     * @param symbol Символ, представляющий состояние точки (например, Symbol.EMPTY, Symbol.CROSS или Symbol.ZERO).
     */
    public Point(Symbol symbol) {
        this.symbol = symbol;
    }

    /**
     * Возвращает символ, представляющий состояние этой точки.
     *
     * @return Символ точки (Symbol).
     */
    public Symbol getSymbol() {
        return symbol;
    }

    /**
     * Устанавливает символ для этой точки.
     *
     * @param symbol Новый символ для точки (Symbol).
     */
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}