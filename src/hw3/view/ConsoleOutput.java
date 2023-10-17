package hw3.view;

import hw3.model.Point;
import hw3.model.Symbol;
import hw3.model.Table;

/**
 * Класс, представляющий устройство вывода на консоль.
 */
public class ConsoleOutput implements OutputDevice {

    /**
     * Отображает игровое поле на консоли.
     *
     * @param table Игровое поле (Table), которое нужно отобразить.
     */
    @Override
    public void showTable(Table table) {

        Point[] field = table.getField();
        int SIZE_X = table.getSIZE_X();
        int SIZE_Y = table.getSIZE_Y();

        for (int y = 0; y < SIZE_Y; y++) {
            for (int x = 0; x < SIZE_X; x++) {
                int index = y * SIZE_X + x;
                Symbol symbol = field[index].getSymbol();

                System.out.print(" " + symbol.getValue() + " ");

                if (x < SIZE_X - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();

            if (y < SIZE_Y - 1) {
                for (int i = 0; i < SIZE_X; i++) {
                    System.out.print("---");
                    if (i < SIZE_X - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Выводит сообщение на консоль.
     *
     * @param message Сообщение для вывода.
     */
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}