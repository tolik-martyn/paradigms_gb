package hw3.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс, представляющий устройство ввода с консоли.
 */
public class ConsoleInput implements InputDevice {
    private final Scanner scanner;

    /**
     * Создает новый экземпляр класса ConsoleInput и инициализирует Scanner для чтения с консоли.
     */
    public ConsoleInput() {
        scanner = new Scanner(System.in);
    }

    /**
     * Запрашивает у пользователя координаты хода (X и Y) с консоли и возвращает их в виде массива.
     *
     * @return Массив с координатами хода (x, y).
     */
    public int[] getUserXAndY() {
        int x = -1, y = -1;
        boolean validInput = false;

        do {
            System.out.print("Введите координаты через пробел (X Y): ");

            try {
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Неправильный ввод. Введите два целых числа через пробел.");
            } finally {
                scanner.nextLine();
            }
        } while (!validInput);

        return new int[]{x, y};
    }

    /**
     * Запрашивает у пользователя текстовые данные с консоли.
     *
     * @return Строка с данными, введенными пользователем.
     */
    @Override
    public String getUserData() {
        return scanner.nextLine();
    }
}