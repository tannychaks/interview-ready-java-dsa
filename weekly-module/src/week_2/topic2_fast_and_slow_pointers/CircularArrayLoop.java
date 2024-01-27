package week_2.topic2_fast_and_slow_pointers;

import java.util.*;

/**
 * This class determines if a circular array has a cycle. A cycle in a circular array is a sequence
 * of indices characterized by the following:
 * - The same set of indices is repeated when traversed in accordance with the given rules.
 * - The length of the sequence is at least two.
 * - The loop must be in a single direction, either forward or backward.
 * <p>
 * The circular array is represented by an array of integers, where each integer represents the number
 * of places to skip forward (if positive) or backward (if negative).
 * <p>
 * Time Complexity: O(N^2), where N is the number of elements in the input array.
 * This is because, in the worst case, we might have to check every element to determine a cycle.
 * <p>
 * Space Complexity: O(1), as we are using constant extra space for variables.
 *
 * @author tanmoychakraborty
 */
public class CircularArrayLoop {

  /**
   * Determines if a circular array has a cycle.
   *
   * @param nums The input circular array represented by an array of integers.
   * @return True if a cycle exists, false otherwise.
   */
  public static boolean circularArrayLoop(int[] nums) {
    int size = nums.length;

    // Iterate through each index of the array 'nums'.
    for (int i = 0; i < size; i++) {
      // Set slow and fast pointers at the current index.
      int slow = i, fast = i;

      // Determine the direction (forward or backward) based on the element's sign.
      boolean forward = nums[i] > 0;

      while (true) {
        // Move the slow pointer to the next step.
        slow = nextStep(slow, nums[slow], size);

        // Check if a cycle is not possible, then break and start from the next element.
        if (isNotCycle(nums, forward, slow)) {
          break;
        }

        // Move the fast pointer to the next step.
        fast = nextStep(fast, nums[fast], size);

        // Check if a cycle is not possible, then break and start from the next element.
        if (isNotCycle(nums, forward, fast)) {
          break;
        }

        // Move the fast pointer to the next step again.
        fast = nextStep(fast, nums[fast], size);

        // Check if a cycle is not possible, then break and start from the next element.
        if (isNotCycle(nums, forward, fast)) {
          break;
        }

        // At any point, if fast and slow pointers meet, a cycle is found, return true.
        if (slow == fast) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * Calculate the next step based on the current pointer and value.
   *
   * @param pointer The current pointer.
   * @param value   The value at the current pointer.
   * @param size    The size of the circular array.
   * @return The next step.
   */
  public static int nextStep(int pointer, int value, int size) {
    int result = (pointer + value) % size;
    if (result < 0) {
      result += size;
    }
    return result;
  }

  /**
   * Check if a cycle is not possible at the given pointer and direction.
   *
   * @param nums          The input circular array.
   * @param prevDirection The previous direction.
   * @param pointer       The current pointer.
   * @return True if a cycle is not possible, false otherwise.
   */
  public static boolean isNotCycle(int[] nums, boolean prevDirection, int pointer) {
    // Determine the current direction based on the element's sign.
    boolean currDirection = nums[pointer] >= 0;

    // If the current direction is different from the previous direction or
    // moving the pointer takes it back to the same value, a cycle is not possible.
    return prevDirection != currDirection || Math.abs(nums[pointer] % nums.length) == 0;
  }

  /**
   * Main method to test the circularArrayLoop function.
   * <p>
   * Please find below explanation of one such example for the above code.
   * <p>
   * 1. The input circular array is `{-5, -4, -3, -2, -1}`.
   * <p>
   * 2. The code starts by iterating through each index of the array:
   * <p>
   *    - **Iteration 1 (i=0):**
   * <p>
   *      - The slow and fast pointers are set to index 0 initially.
   *      - The `forward` flag is set to `false` because `nums[0]` is negative.
   *      - The while loop begins:
   *        - Slow pointer moves to index 0 - 5 = -5. Since the index cannot be negative, it wraps around to the end of the array, making it index 4 (the last element).
   *        - The condition `isNotCycle` checks if the current direction (`currDirection`) is different from the previous direction (`prevDirection`) or if moving a pointer takes it back to the same value. In this case, both conditions are true.
   *        - The loop breaks because it cannot form a cycle starting from index 0.
   * <p>
   *    - **Iteration 2 (i=1):**
   * <p>
   *      - The slow and fast pointers are set to index 1 initially.
   *      - The `forward` flag is set to `false` because `nums[1]` is negative.
   *      - The while loop begins:
   *        - Slow pointer moves to index 1 - 4 = -3. It wraps around to index 2.
   *        - Fast pointer moves to index 1 - 4 = -3. It also wraps around to index 2.
   *        - Both pointers now point to index 2.
   *        - The condition `slow == fast` is true, indicating that a cycle has been found.
   *        - The function returns `true` because it found a cycle.
   * <p>
   * 3. The code prints the result: "Found Loop = true" for the input `{ -5, -4, -3, -2, -1 }`.
   * <p>
   * So, in this specific case, the code correctly identifies that a cycle exists in the circular array, and it returns `true` for this input.
   *
   * @param args Command line arguments (not used in this program).
   */
  public static void main(String[] args) {
    int[][] input = {
        {-2, -3, -9},
        {-5, -4, -3, -2, -1},
        {-1, -2, -3, -4, -5},
        {2, 1, -1, -2},
        {-1, -2, -3, -4, -5, 6},
        {1, 2, -3, 3, 4, 7, 1},
        {2, 2, 2, 7, 2, -1, 2, -1, -1}
    };

    for (int i = 0; i < input.length; i++) {
      System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
      boolean result = circularArrayLoop(input[i]);
      System.out.println("\tFound Loop = " + result);
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}