package hw6.mse;

import java.util.stream.IntStream;

/**
 * Класс MSECalculator предназначен для вычисления среднеквадратичной ошибки (MSE) между двумя векторами.
 */
public class MSECalculator {

    public static void main(String[] args) {
        double[] actualSales = {100.0, 150.0, 200.0, 250.0};
        double[] predictedSales = {110.0, 140.0, 190.0, 260.0};

        double mse = calculateMSE(actualSales, predictedSales);
        System.out.println("MSE: " + mse);
    }

    /**
     * Вычисляет среднеквадратичную ошибку (MSE) между фактическими и предсказанными значениями.
     *
     * @param actual    Массив с фактическими значениями.
     * @param predicted Массив с предсказанными значениями.
     * @return Оценка среднеквадратичной ошибки между фактическими и предсказанными значениями.
     * @throws IllegalArgumentException Если длины массивов actual и predicted не совпадают.
     */
    public static double calculateMSE(double[] actual, double[] predicted) {
        if (actual.length != predicted.length) {
            throw new IllegalArgumentException("Длины векторов не совпадают");
        }

        return IntStream.range(0, actual.length)
                .mapToDouble(i -> Math.pow(actual[i] - predicted[i], 2))
                .average()
                .orElse(0);
    }
}