package week_1.sorting_leetcode;

import java.util.Arrays;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 * <p>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *</p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SortColors {
  public static void main(String[] args) {
    int[] arr = new int[] { 2, 0, 2, 1, 1, 0 };
    sortColors(arr);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Sorts an array containing 0s, 1s, and 2s (representing colors) in-place.
   * Uses the Dutch National Flag algorithm.
   * @param nums The array to be sorted.
   */
  public static void sortColors(int[] nums) {
    int i = 0, j = 0, k = nums.length - 1;
    while (j <= k) {
      switch (nums[j]) {
        case 0:
          // Swap 0s to the front
          nums[i] += nums[j] - (nums[j] = nums[i]);
          i++;
          j++;
          break;
        case 1:
          // Leave 1s in the middle
          j++;
          break;
        case 2:
          // Swap 2s to the back
          nums[j] += nums[k] - (nums[k] = nums[j]);
          k--;
          break;
      }
    }
  }
}
