package week_1.sorting;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 5, -1, 0, 1, 2, 6, -4, 8};
    int n = arr.length;

    sort(arr, 0, n - 1);
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
   * Main function that sorts arr[l..r] using merge(). Time Complexity: O(n log n) for all cases.
   * Space Complexity: O(n) as it requires additional space for the temporary arrays.
   *
   * @param arr The array to be sorted.
   * @param l   The starting index.
   * @param r   The ending index.
   */
  private static void sort(int[] arr, int l, int r) {
    if (l < r) {
      // Find the middle point
      int mid = (l + r) / 2;

      // Sort first and second halves
      sort(arr, l, mid);
      sort(arr, mid + 1, r);

      // Merge the sorted halves
      merge(arr, l, mid, r);
    }
  }

  /**
   * Merges two subarrays of arr[]. First subarray is arr[l..mid] Second subarray is arr[mid+1..r]
   *
   * @param arr The array to be merged.
   * @param l   The starting index of the first subarray.
   * @param mid The ending index of the first subarray.
   * @param r   The ending index of the second subarray.
   */
  private static void merge(int[] arr, int l, int mid, int r) {
    // Sizes of two subarrays to be merged
    int n1 = mid - l + 1;
    int n2 = r - mid;

    // Create temp arrays
    int[] left = new int[n1];
    int[] right = new int[n2];

    // Copy data to temp arrays
    for (int i = 0; i < n1; ++i) {
      left[i] = arr[l + i];
    }
    for (int j = 0; j < n2; ++j) {
      right[j] = arr[mid + 1 + j];
    }

    // Merge the temp arrays back into arr[l..r]
    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }

    // Copy remaining elements of left[], if any
    while (i < n1) {
      arr[k] = left[i];
      i++;
      k++;
    }

    // Copy remaining elements of right[], if any
    while (j < n2) {
      arr[k] = right[j];
      j++;
      k++;
    }
  }
}
