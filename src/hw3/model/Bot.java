package hw3.model;

/**
 * Класс, представляющий бота в игре.
 */
public class Bot extends Player {

    /**
     * Создает новый экземпляр класса Bot с указанными именем и символом.
     *
     * @param name   Имя бота.
     * @param symbol Символ, которым играет бот (например, Symbol.CROSS или Symbol.ZERO).
     */
    public Bot(String name, Symbol symbol) {
        super(name, symbol);
    }
}