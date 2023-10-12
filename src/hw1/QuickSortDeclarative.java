package hw1;

import java.util.Arrays;

/**
 * Класс, представляющий декларативную реализацию быстрой сортировки.
 */
public class QuickSortDeclarative {

    /**
     * Метод для сортировки массива с использованием декларативного подхода.
     *
     * @param arr Исходный массив для сортировки.
     * @return Отсортированный массив.
     */
    public int[] quickSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int pivot = arr[arr.length - 1];
        int[] less = Arrays.stream(arr).filter(x -> x < pivot).toArray();
        int[] equal = Arrays.stream(arr).filter(x -> x == pivot).toArray();
        int[] greater = Arrays.stream(arr).filter(x -> x > pivot).toArray();

        int[] sortedGreater = quickSort(greater);
        int[] sortedLess = quickSort(less);

        return concat(sortedGreater, equal, sortedLess);
    }

    /**
     * Метод для объединения трех массивов в один.
     *
     * @param a Первый массив.
     * @param b Второй массив.
     * @param c Третий массив.
     * @return Объединенный массив.
     */
    private int[] concat(int[] a, int[] b, int[] c) {
        int[] result = new int[a.length + b.length + c.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        System.arraycopy(c, 0, result, a.length + b.length, c.length);
        return result;
    }
}
