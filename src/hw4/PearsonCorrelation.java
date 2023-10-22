package hw4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PearsonCorrelation {

    public static void main(String[] args) {

        // Создаем два массива случайных величин
        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] y = {2.0, 4.0, 3.5, 4.5, 6.0};

        // Вычисляем корреляцию Пирсона
        double correlation = calculatePearsonCorrelation(x, y);

        System.out.println("Корреляция Пирсона: " + correlation);
    }

    public static double calculatePearsonCorrelation(double[] x, double[] y) {
        // Проверяем, что массивы имеют одинаковую длину
        if (x.length != y.length) {
            throw new IllegalArgumentException("Массивы должны иметь одинаковую длину");
        }

        int n = x.length;

        // Вычисляем средние значения x и y
        double meanX = Arrays.stream(x).average().orElse(0);
        double meanY = Arrays.stream(y).average().orElse(0);

        // Вычисляем числитель и знаменатель для корреляции Пирсона
        double numerator = IntStream.range(0, n)
                .mapToDouble(i -> (x[i] - meanX) * (y[i] - meanY))
                .sum();

        double denominatorX = Math.sqrt(IntStream.range(0, n)
                .mapToDouble(i -> Math.pow(x[i] - meanX, 2))
                .sum());

        double denominatorY = Math.sqrt(IntStream.range(0, n)
                .mapToDouble(i -> Math.pow(y[i] - meanY, 2))
                .sum());

        // Вычисляем корреляцию Пирсона
        if (denominatorX == 0 || denominatorY == 0) {
            return 0; // Избегаем деления на ноль
        } else {
            return numerator / (denominatorX * denominatorY);
        }
    }
}
