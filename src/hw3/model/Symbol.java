package hw3.model;

/**
 * Перечисление, представляющее символы на игровом поле (пусто, крестик, нолик).
 */
public enum Symbol {
    EMPTY(' '), CROSS('X'), ZERO('0');

    private final char value;

    /**
     * Создает новый экземпляр символа с указанным значением.
     *
     * @param value Значение символа.
     */
    Symbol(char value) {
        this.value = value;
    }

    /**
     * Возвращает значение символа.
     *
     * @return Значение символа (char).
     */
    public char getValue() {
        return value;
    }
}