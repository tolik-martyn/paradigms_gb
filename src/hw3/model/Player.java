package hw3.model;

/**
 * Класс, представляющий игрока в игре в крестики-нолики.
 */
public class Player {
    private final String name;
    private final Symbol symbol;

    /**
     * Создает новый экземпляр класса Player с указанными параметрами.
     *
     * @param name   Имя игрока.
     * @param symbol Символ, которым играет игрок (например, Symbol.CROSS или Symbol.ZERO).
     */
    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Возвращает имя игрока.
     *
     * @return Имя игрока.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает символ, которым играет игрок.
     *
     * @return Символ игрока (Symbol).
     */
    public Symbol getSymbol() {
        return symbol;
    }
}