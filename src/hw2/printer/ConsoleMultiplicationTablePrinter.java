package hw2.printer;

import hw2.exception.InvalidInputException;

import java.util.Scanner;

/**
 * Класс, реализующий интерфейс IMultiplicationTablePrinter и отвечающий за вывод таблицы умножения на консоль и за получение данных с консоли;
 */
public class ConsoleMultiplicationTablePrinter implements IMultiplicationTablePrinter {

    @Override
    public void printMultiplicationTable(int n) {
        System.out.println("Таблица умножения от 1 до " + n + ":");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%2d * %2d = %4d  |  ", i, j, i * j);
            }
            System.out.println();
        }
    }

    @Override
    public int getInputData() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            try {
                System.out.print("Введите число n для построения таблицы умножения: ");
                userInput = scanner.nextLine();
                if (userInput == null || userInput.isEmpty()) {
                    throw new InvalidInputException("Введено пустое значение.", userInput);
                }
                int n = Integer.parseInt(userInput);
                if (n <= 0) {
                    throw new InvalidInputException("Число должно быть больше 0.", userInput);
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите целое число.");
            } catch (InvalidInputException e) {
                System.out.println("Ошибка: \"" + e.getMessage() + "\", введено \"" + e.getInput() + "\"");
            }
        }
    }
}
