package week_2.topic1_two_pointers;

/**
 * A utility class for checking whether a given string is a valid alphanumeric palindrome.
 *
 * @author tanmoychakraborty
 */
public class ValidPalindrome {

  /**
   * Checks if a string is a valid alphanumeric palindrome.
   *
   * @param s The input string to check.
   * @return {@code true} if the input string is a valid alphanumeric palindrome, {@code false} otherwise.
   *
   * @implNote This method uses a Two-Pointer approach to efficiently check for palindromes.
   * It iterates through the string while comparing characters from the start and end, ignoring
   * non-alphanumeric characters and performing a case-insensitive comparison.
   * <p>
   * @complexity
   *     - Time Complexity: O(n), where n is the length of the input string.
   *     - Space Complexity: O(1), as it uses a constant amount of additional space for the pointers.
   */
  private static boolean isPalindrome(String s) {
    if (s == null) {
      // An empty or null string is considered a palindrome.
      return true;
    }

    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }

      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }

  public static void main(String[] args) {
    String input = "A man, a plan, a canal, Panama";
    boolean result = isPalindrome(input);
    System.out.println("Is the input a valid alphanumeric palindrome? " + result);
  }
}
