package week_2.topic2_fast_and_slow_pointers;

import java.util.*;

/**
 * Given an unsorted array of positive numbers, 'nums,' such that the values lie in the range [1, n],
 * inclusive, and there are n+1 numbers in the array, this class finds and returns the duplicate number
 * present in 'nums.' There is only one repeated number in 'nums.'
 * <p>
 * Note: You cannot modify the given array 'nums.' This problem is solved using only constant
 * extra space.
 * <p>
 * Algorithm Explanation:
 * The algorithm uses the Floyd's Tortoise and Hare (Cycle Detection) approach to find the duplicate number.
 * It consists of two main parts:
 * 1. Finding the Intersection Point: It starts with two pointers, 'fast' and 'slow,' both initialized
 *    to the first element of the array. 'fast' moves twice as fast as 'slow.' When they meet, it indicates
 *    that there is a cycle in the array.
 * 2. Finding the Duplicate: After detecting the intersection point, one of the pointers (in this case, 'slow')
 *    is reset to the beginning of the array. Both pointers move at the same pace (one step at a time) until
 *    they meet again. The point where they meet is the duplicate number.
 * <p>
 * Time Complexity:
 * - The algorithm runs in O(n) time, where 'n' is the length of the input array 'nums.' This is because the
 *   algorithm always detects the cycle within a single traversal of the array.
 * <p>
 * Space Complexity:
 * - The algorithm uses constant extra space, O(1), as it only maintains two pointers ('fast' and 'slow') and
 *   a few variables for index manipulation.
 *
 * @author tanmoychakraborty
 */
public class FindDuplicate {

  /**
   * Finds and returns the duplicate number present in the given unsorted array 'nums.'
   *
   * @param nums The input array containing positive numbers with a duplicate.
   * @return The duplicate number found in 'nums.'
   */
  public static int findDuplicate(int[] nums) {
    // Initialize the fast and slow pointers and make them point to the first
    // element of the array
    int fast = nums[0];
    int slow = nums[0];

    // PART #1 - Traverse to detect intersection
    do {
      // Move the slow pointer using the nums[slow] flow
      slow = nums[slow];
      // Move the fast pointer two times as fast as the slow pointer using the
      // nums[nums[fast]] flow
      fast = nums[nums[fast]];
      // Break the loop when the slow pointer becomes equal to the fast pointer, indicating
      // the intersection of the cycle
    } while (slow != fast);

    // PART #2 - Traverse to find the duplicate
    // Make the slow pointer point to the beginning of the array again
    slow = nums[0];
    // Traverse the array until the slow pointer becomes equal to the fast pointer
    while (slow != fast) {
      // Move the slow pointer using the nums[slow] flow
      slow = nums[slow];
      // Move the fast pointer slower than before, i.e., move the fast pointer
      // using the nums[fast] flow
      fast = nums[fast];
    }

    // Return the fast pointer as it points to the duplicate number in the array
    return fast;
  }

  // Driver code
  public static void main(String[] args) {
    int[][] nums = {
        {1, 3, 2, 3, 5, 4},
        {2, 4, 5, 4, 1, 3},
        {1, 6, 3, 5, 1, 2, 7, 4},
        {1, 2, 2, 4, 3},
        {3, 1, 3, 5, 6, 4, 2}
    };
    for (int i = 0; i < nums.length; i++) {
      System.out.print(i + 1);
      System.out.println(".\tnums = " + Arrays.toString(nums[i]));
      System.out.println("\tDuplicate number = " + findDuplicate(nums[i]));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}
