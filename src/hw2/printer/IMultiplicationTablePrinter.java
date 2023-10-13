package hw2.printer;

/**
 * Интерфейс для вывода таблицы умножения.
 */
public interface IMultiplicationTablePrinter {

    /**
     * Выводит таблицу умножения на консоль.
     *
     * @param n число для построения таблицы умножения
     */
    void printMultiplicationTable(int n);

    /**
     * Получает данные от пользователя
     *
     * @return введенное пользователем число
     */
    int getInputData();
}
