package week_1.sorting;

public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 4, 1, 1, 5, -2};
    int n = arr.length;
    sort(arr, n);
    printArray(arr);
  }

  /**
   * Prints the elements of the array.
   *
   * @param arr The array to be printed.
   */
  private static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  /**
   * Sorts the array using bubble sort algorithm. Time Complexity: O(n^2) in the worst and average
   * case, O(n) in the best case. Space Complexity: O(1) as it's an in-place sorting algorithm.
   *
   * @param arr The array to be sorted.
   * @param n   The number of elements in the array.
   */
  private static void sort(int[] arr, int n) {
    for (int i = 0; i < n - 1; i++) {
      boolean swapped = false;
      // Perform a pass over the array.
      for (int j = 0; j < n - i - 1; j++) {
        // Swap if the elements are in the wrong order.
        if (arr[j] > arr[j + 1]) {
          arr[j] += arr[j + 1] - (arr[j + 1] = arr[j]); // One-Liner Swap
          swapped = true;
        }
      }
      // If no two elements were swapped, the array is sorted.
      if (!swapped) {
        break;
      }
    }
  }
}

