package hw2.generator;

import hw2.printer.IMultiplicationTablePrinter;

/**
 * Класс, отвечающий за бизнес-логику и использующий IMultiplicationTablePrinter для генерации и вывода таблицы умножения.
 */
public class MultiplicationTableGenerator {
    private final IMultiplicationTablePrinter printer;

    /**
     * Создает новый экземпляр класса MultiplicationTableGenerator с заданным принтером.
     *
     * @param printer принтер для вывода таблицы умножения
     */
    public MultiplicationTableGenerator(IMultiplicationTablePrinter printer) {
        this.printer = printer;
    }

    /**
     * Генерирует и выводит таблицу умножения для числа n.
     *
     * @param n число для построения таблицы умножения
     */
    public void generateMultiplicationTable(int n) {
        printer.printMultiplicationTable(n);
    }

    /**
     * Получает данные от пользователя
     *
     * @return введенное пользователем число
     */
    public int getInputData() {
        return printer.getInputData();
    }
}
