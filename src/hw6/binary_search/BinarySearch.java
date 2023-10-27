package hw6.binary_search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 42, 58, 67};
        int target = 16;

        int index = binarySearch(sortedArray, target);

        if (index != -1) {
            System.out.println("Элемент " + target + " найден в массиве по индексу " + index);
        } else {
            System.out.println("Элемент " + target + " не найден в массиве.");
        }
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Нашли искомый элемент
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Элемент не найден
    }
}