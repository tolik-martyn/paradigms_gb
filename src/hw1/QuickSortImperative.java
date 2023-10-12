package hw1;

/**
 * Класс, представляющий императивную реализацию быстрой сортировки.
 */
public class QuickSortImperative {

    /**
     * Метод для сортировки массива с использованием императивного подхода.
     *
     * @param arr Исходный массив для сортировки.
     * @return Отсортированный массив.
     */
    public int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] >= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }
}
