package week_1.sorting_leetcode;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array <a href="https://leetcode.com/problems/merge-sorted-array/">[Merge Sorted Array]</a>
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two
 * integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the
 * array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote
 * the elements that should be merged, and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 *
 * @author tanmoychakraborty
 */
public class MergeSortedArray {

  /**
   * Main method to demonstrate merging of two sorted arrays.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int[] nums2 = new int[]{2, 5, 6};

    int m = 3, n = 3;

    merge(nums1, m, nums2, n);
    printArray(nums1);
  }

  /**
   * Prints the elements of the array.
   *
   * @param nums1 The array to be printed.
   */
  private static void printArray(int[] nums1) {
    Arrays.stream(nums1).forEach(num -> System.out.print(num + " "));
  }

  /**
   * Merges two sorted arrays into one sorted array.
   *
   * @TimeComplexity : O(m + n)
   *
   * @SpaceComplexity: O(1)
   *
   * @param nums1 The first sorted array and the array to hold the merged result.
   * @param m     The number of elements in nums1 that are part of the merge.
   * @param nums2 The second sorted array.
   * @param n     The number of elements in nums2.
   */
  private static void merge(int[] nums1, int m, int[] nums2, int n) {
    int maxOf1 = m - 1, maxOf2 = n - 1;
    for (int i = m + n - 1; i >= 0; i--) {
      // Compare elements from the end of nums1 and nums2
      // and fill nums1 from the end
      if (maxOf1 >= 0 && maxOf2 >= 0) {
        if (nums1[maxOf1] > nums2[maxOf2]) {
          nums1[i] = nums1[maxOf1--];
        } else {
          nums1[i] = nums2[maxOf2--];
        }
      } else if (maxOf1 >= 0) {
        // If nums2 is exhausted, copy remaining nums1
        nums1[i] = nums1[maxOf1--];
      } else {
        // If nums1 is exhausted, copy remaining nums2
        nums1[i] = nums2[maxOf2--];
      }
    }
  }
}
