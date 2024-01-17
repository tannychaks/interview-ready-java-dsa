package week_1.sorting;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
    System.out.println("Before Quick Sort: " + Arrays.toString(arr));
    quickSort(arr);
    System.out.println("After Quick Sort: " + Arrays.toString(arr));
  }

  /**
   * Sorts an array using the Quick Sort algorithm. Time Complexity: - Best and Average Cases: O(n
   * log n) - Worst Case: O(n^2)
   *
   * @param arr The array to be sorted.
   */
  private static void quickSort(int[] arr) {
    quickSortRecursive(arr, 0, arr.length - 1);
  }

  /**
   * Recursively sorts subarrays of the given array.
   *
   * @param arr  The array to be sorted.
   * @param low  The starting index of the subarray.
   * @param high The ending index of the subarray.
   */
  private static void quickSortRecursive(int[] arr, int low, int high) {
    if (low < high) {
      int partitionIndex = partition(arr, low, high);
      quickSortRecursive(arr, low, partitionIndex - 1);
      quickSortRecursive(arr, partitionIndex + 1, high);
    }
  }

  /**
   * Partitions the array around a pivot.
   *
   * @param arr  The array to be partitioned.
   * @param low  The starting index for the partition.
   * @param high The ending index for the partition.
   * @return The index of the partition.
   */
  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[low];
    int i = low;
    int j = high;

    while (i < j) {
      while (i <= high - 1 && arr[i] <= pivot) {
        i++;
      }
      while (j >= low + 1 && arr[j] > pivot) {
        j--;
      }
      if (i < j) {
        swap(arr, i, j);
      }
    }
    swap(arr, low, j);
    return j;
  }

  /**
   * Swaps two elements in an array.
   *
   * @param arr The array where the swap will occur.
   * @param i   The index of the first element.
   * @param j   The index of the second element.
   */
  private static void swap(int[] arr, int i, int j) {
    arr[j] += arr[i] - (arr[i] = arr[j]); //one liner swap
  }

}
