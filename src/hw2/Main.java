package hw2;

import hw2.generator.MultiplicationTableGenerator;
import hw2.printer.ConsoleMultiplicationTablePrinter;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр класса MultiplicationTableGenerator, который отвечает за генерацию и вывод таблицы умножения.
        MultiplicationTableGenerator tableGenerator = new MultiplicationTableGenerator(
                new ConsoleMultiplicationTablePrinter());

        // Генерируем и выводим таблицу умножения, запрашивая у пользователя входные данные.
        tableGenerator.generateMultiplicationTable(
                tableGenerator.getInputData());
    }
}
