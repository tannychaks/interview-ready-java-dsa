package week_2.topic2_fast_and_slow_pointers;

/**
 * HappyNumber class contains methods to determine if a given number is a happy number.
 *
 * <p> A happy number is defined by the following process:
 * Starting with a positive integer n, replace the number with the sum of the squares of its digits.
 * Repeat this process until the number equals 1 (indicating it's a happy number) or enters a cycle
 * (indicating it's not a happy number).
 *
 * <p> This implementation uses a slow and fast pointer approach to detect cycles in the number sequence.
 *
 * <p> Time Complexity: O(log n) - In most cases, the algorithm terminates much before reaching 1.
 * Space Complexity: O(1) - Constant space is used for pointers and variables.
 *
 * @author tanmoychakraborty
 */
public class HappyNumber {

  /**
   * Calculates the sum of the squares of the digits of a number.
   *
   * @param number The input number.
   * @return The sum of the squares of the digits.
   */
  public static int sumOfSquaredDigits(int number) {
    int totalSum = 0;
    while (number != 0) {
      int digit = number % 10;
      number = number / 10;
      totalSum += (int) Math.pow(digit, 2);
    }
    return totalSum;
  }

  /**
   * Checks if a given number is a happy number.
   *
   * @param n The input number to check.
   * @return True if the number is a happy number, false otherwise.
   */
  public static boolean isHappyNumber(int n) {
    int slowPointer = n;
    int fastPointer = sumOfSquaredDigits(n);

    while (fastPointer != 1 && slowPointer != fastPointer) {
      slowPointer = sumOfSquaredDigits(slowPointer);
      fastPointer = sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
    }
    return fastPointer == 1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 5, 19, 25, 7};
    for (int i = 0; i < nums.length; i++) {
      System.out.println((i + 1) + ".\tInput Number: " + nums[i]);
      String output = isHappyNumber(nums[i]) ? "True" : "False";

      System.out.println("\n\tIs it a happy number? " + output);
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}
