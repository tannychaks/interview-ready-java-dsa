package week_2.topic1_two_pointers;

import java.util.Arrays;

/**
 * Given an array of integers, nums, and an integer value, target, determine if there are any three
 * integers in nums whose sum is equal to the target, that is, nums[i] + nums[j] + nums[k] ==
 * target. Return TRUE if three such integers exist in the array. Otherwise, return FALSE.
 * <p>
 * Note: A valid triplet consists of elements with distinct indexes. This means, for the triplet
 * nums[i], nums[j], and nums[k], i ≠ j, i ≠ k, and j ≠ k.
 *
 * @author tanmoychakraborty
 */
public class SumOfThree {

  /**
   * Checks if there exist three integers in the input array whose sum is equal to the target.
   *
   * @param nums   The input array of integers.
   * @param target The target sum value to be checked.
   * @return {@code true} if there exist three integers in the array whose sum equals the target,
   * {@code false} otherwise.
   * <p>
   * @implNote This method uses the Two-Pointer approach to efficiently search for the triplet sum
   * equal to the target. It first sorts the input array, and then it iterates through the array
   * fixing one integer at a time and finding the other two using two pointers.
   * <p>
   * @complexity - Time Complexity: O(n^2), where n is the length of the input array. The time
   * complexity is dominated by the nested loop for finding the triplets. - Space Complexity: O(1),
   * as it uses a constant amount of additional space for the pointers.
   */
  private static boolean isSumEqualsTarget(int[] nums, int target) {
    // Sort the input list
    Arrays.sort(nums);
    int low, high, triples;

    // Fix one integer at a time and find the other two
    for (int i = 0; i < nums.length - 2; i++) {
      // Initialize the two pointers
      low = i + 1;
      high = nums.length - 1;

      // Traverse the list to find the triplet whose sum equals the target
      while (low < high) {
        triples = nums[i] + nums[low] + nums[high];

        // The sum of the triplet equals the target
        if (triples == target) {
          return true;
        }
        // The sum of the triplet is less than target, so move the low pointer forward
        else if (triples < target) {
          low++;
        }
        // The sum of the triplet is greater than target, so move the high pointer backward
        else {
          high--;
        }
      }
    }

    // No such triplet found whose sum equals the given target
    return false;
  }

  public static void main(String[] args) {
    // Example usage:
    int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
        {-1, 2, 1, -4, 5, -3},
        {2, 3, 4, 1, 7, 9},
        {1, -1, 0},
        {2, 4, 2, 7, 6, 3, 1}};

    int[] testList = {10, 7, 20, -1, 8};

    for (int i = 0; i < testList.length; i++) {
      System.out.print(i + 1);
      System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));

      if (isSumEqualsTarget(numsList[i], testList[i])) {
        System.out.println("\tSum for " + testList[i] + " exists ");
      } else {
        System.out.println("\tSum for " + testList[i] + " does not exist ");
      }

      System.out.println("--------------------------------------------------------------------");
    }
  }
}
