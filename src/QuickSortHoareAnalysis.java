import java.util.Arrays;
import java.util.Random;

public class QuickSortHoareAnalysis {

    private static int comparisons;
    private static int swaps;

    public static void main(String[] args) {
        System.out.println("Трудоемкость метода Хоара (Мф+Сф)");
        System.out.println("N\tУбыв.\tВозр.\tСлуч.");

        int[] sizes = {100, 200, 300, 400, 500};
        for (int n : sizes) {
            // Генерируем тестовые массивы
            int[] descending = generateDescendingArray(n);
            int[] ascending = generateAscendingArray(n);
            int[] random = generateRandomArray(n);

            // Тестируем на убывающем массиве
            resetCounters();
            quickSort(descending.clone());
            int descCost = comparisons + swaps;

            // Тестируем на возрастающем массиве
            resetCounters();
            quickSort(ascending.clone());
            int ascCost = comparisons + swaps;

            // Тестируем на случайном массиве
            resetCounters();
            quickSort(random.clone());
            int randCost = comparisons + swaps;

            System.out.printf("%d\t%d\t%d\t%d%n", n, descCost, ascCost, randCost);
        }
    }

    // QuickSort с разбиением Хоара
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partitionHoare(arr, low, high);
            quickSort(arr, low, p);
            quickSort(arr, p + 1, high);
        }
    }

    // Разбиение Хоара
    private static int partitionHoare(int[] arr, int low, int high) {
        int pivot = arr[low + (high - low) / 2];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
                comparisons++;
            } while (arr[i] < pivot);

            do {
                j--;
                comparisons++;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
            swaps++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void resetCounters() {
        comparisons = 0;
        swaps = 0;
    }

    // Генерация тестовых массивов
    private static int[] generateDescendingArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    private static int[] generateAscendingArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    private static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n * 10);
        }
        return arr;
    }
}