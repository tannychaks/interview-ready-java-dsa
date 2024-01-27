package week_1.sorting;

import java.util.Arrays;

/**
 * This code demonstrates Selection sort technique.
 *
 * @author tanmoychakraborty
 */
public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 5, -2, -2, 3, 4};
    int n = arr.length;

    // Unstable Selection Sort
    System.out.println("Unstable Selection Sort:");
    sort(arr, n);
    printArray(arr);
    System.out.println(); // For a new line

    // Resetting array for Stable Selection Sort
    arr = new int[]{1, 5, -2, -2, 3, 4};

    // Stable Selection Sort
    System.out.println("Stable Selection Sort:");
    stableSelectionSort(arr, n);
    printArray(arr);
  }

  /**
   * Prints the elements of the array.
   *
   * @param arr The array to be printed.
   */
  private static void printArray(int[] arr) {
    Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    System.out.println();
  }

  /**
   * Performs an unstable selection sort on the array. Unstable because swapping might change the
   * relative order of equal elements. Time Complexity: O(n^2) for all cases. Space Complexity: O(1)
   * as it's an in-place sorting algorithm.
   *
   * @param arr The array to be sorted.
   * @param n   The number of elements in the array.
   */
  private static void sort(int[] arr, int n) {
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[min] > arr[j]) {
          min = j;
        }
      }
      // Swapping might change the relative order of equal elements
      arr[min] += arr[i] - (arr[i] = arr[min]); // One-Liner Swap
    }
  }

  /**
   * Performs a stable selection sort on the array. Stable because it does not change the relative
   * order of equal elements. Time Complexity: O(n^2) for all cases. Space Complexity: O(1) as it's
   * an in-place sorting algorithm.
   * <p>
   * Note: Subscripts are only used for understanding the concept.
   * <p>
   * Input : 4A 5 3 2 4B 1 Output : 1 2 3 4B 4A 5
   * <p>
   * Stable Selection Sort would have produced Output : 1 2 3 4A 4B 5
   *
   * @param arr The array to be sorted.
   * @param n   The number of elements in the array.
   */
  private static void stableSelectionSort(int[] arr, int n) {
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[min] > arr[j]) {
          min = j;
        }
      }
      // Moving the minimum element to its correct position without swapping
      int key = arr[min];
      while (min > i) {
        arr[min] = arr[min - 1];
        min--;
      }
      arr[i] = key;
    }
  }
}
