package hw1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10000;
        int[] arr = new int[n];
        Random random = new Random();

        // Заполняем массив случайными числами
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }

        // Императивная сортировка
        int[] arrImperative = Arrays.copyOf(arr, arr.length);
        long startTimeImperative = System.currentTimeMillis();
        QuickSortImperative quickSortImperative = new QuickSortImperative();
        int[] arrSortImperative = quickSortImperative.quickSort(arrImperative);
        long endTimeImperative = System.currentTimeMillis();
        long elapsedTimeImperative = endTimeImperative - startTimeImperative;

        // Декларативная сортировка
        int[] arrDeclarative = Arrays.copyOf(arr, arr.length);
        long startTimeDeclarative = System.currentTimeMillis();
        QuickSortDeclarative quickSortDeclarative = new QuickSortDeclarative();
        int[] arrSortDeclarative = quickSortDeclarative.quickSort(arrDeclarative);
        long endTimeDeclarative = System.currentTimeMillis();
        long elapsedTimeDeclarative = endTimeDeclarative - startTimeDeclarative;

        // Вывод результатов
        System.out.println("Императивная сортировка заняла " + elapsedTimeImperative + " миллисекунд.");
        System.out.println("Декларативная сортировка заняла " + elapsedTimeDeclarative + " миллисекунд.");

        // Проверка совпадения массивов
        System.out.println("Императивная и декларативная сортировки совпадают: " +
                (Arrays.equals(arrSortImperative, arrSortDeclarative) ? "да" : "нет"));
    }
}
