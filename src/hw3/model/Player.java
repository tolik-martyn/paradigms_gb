package hw3.model;

/**
 * Класс, представляющий игрока в игре в крестики-нолики.
 */
public class Player {
    protected final String name;
    protected final Symbol symbol;
    protected boolean isBot;

    /**
     * Создает новый экземпляр класса Player с указанными параметрами.
     *
     * @param name   Имя игрока.
     * @param symbol Символ, которым играет игрок (например, Symbol.CROSS или Symbol.ZERO).
     */
    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
        this.isBot = false;
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

    public boolean isBot() {
        return isBot;
    }
}