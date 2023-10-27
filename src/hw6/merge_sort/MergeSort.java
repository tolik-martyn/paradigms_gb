package hw6.merge_sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] unsortedArray = {38, 27, 43, 3, 9, 82, 10};
        int[] sortedArray = mergeSort(unsortedArray);

        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArray));
    }

    public static int[] mergeSort(int[] array) {

        if (array.length <= 1) {
            return array; // Базовый случай: массив уже отсортирован
        }

        // Разделяем массив на две части
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);

        // Рекурсивно сортируем обе части
        left = mergeSort(left);
        right = mergeSort(right);

        // Объединяем отсортированные части в один массив
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        // Сливаем элементы из left и right в result
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        // Копируем оставшиеся элементы, если такие есть
        System.arraycopy(left, leftIndex, result, resultIndex, left.length - leftIndex);
        System.arraycopy(right, rightIndex, result, resultIndex, right.length - rightIndex);

        return result;
    }
}