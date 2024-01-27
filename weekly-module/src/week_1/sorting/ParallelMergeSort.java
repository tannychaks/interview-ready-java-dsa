package week_1.sorting;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * This code demonstrates Merge sort for large datasets involving concurrency.
 *
 * @author tanmoychakraborty
 */
public class ParallelMergeSort {

  /**
   * Main method to run the parallel merge sort.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    int[] arr = new int[]{2, 3, 4, 3, 4, 2, 1, -3, 0, -9, 0, 45, 23, 12, 0, 55, 11, -99, -34, -43,
        -55, -3/* large dataset */};
    try (ForkJoinPool pool = new ForkJoinPool()) {
      pool.invoke(new MergeSortTask(arr, 0, arr.length - 1));
    }
    System.out.println(Arrays.toString(arr));
  }

  /**
   * A class representing a task for merge sorting an array segment.
   */
  static class MergeSortTask extends RecursiveAction {

    private int[] arr;
    private int left, right;

    /**
     * Constructs a MergeSortTask.
     *
     * @param arr   The array to sort.
     * @param left  The starting index of the segment to sort.
     * @param right The ending index of the segment to sort.
     */
    MergeSortTask(int[] arr, int left, int right) {
      this.arr = arr;
      this.left = left;
      this.right = right;
    }

    /**
     * The main computation performed by this task.
     */
    @Override
    protected void compute() {
      if (left < right) {
        int mid = (left + right) / 2;

        // Split the task into two and fork new tasks
        MergeSortTask leftTask = new MergeSortTask(arr, left, mid);
        MergeSortTask rightTask = new MergeSortTask(arr, mid + 1, right);

        invokeAll(leftTask, rightTask);

        // Merge the sorted halves
        merge(arr, left, mid, right);
      }
    }

    /**
     * Merges two sorted sub-arrays of arr[]. First sub-array is arr[left..mid] Second sub-array is
     * arr[mid+1..right]
     *
     * @param arr   The array to be merged.
     * @param left  The starting index of the first sub-array.
     * @param mid   The ending index of the first sub-array.
     * @param right The ending index of the second sub-array.
     */
    private void merge(int[] arr, int left, int mid, int right) {
      int n1 = mid - left + 1;
      int n2 = right - mid;

      int[] L;
      int[] R;

      L = IntStream.range(0, n1).map(i -> arr[left + i]).toArray();
      R = IntStream.range(0, n2).map(j -> arr[mid + 1 + j]).toArray();

      int i = 0, j = 0;

      int k = left;
      while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
          arr[k] = L[i];
          i++;
        } else {
          arr[k] = R[j];
          j++;
        }
        k++;
      }

      while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
      }

      while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
      }
    }
  }
}

