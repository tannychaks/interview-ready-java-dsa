package week_2.topic1_two_pointers;

/**
 * ValidPalindromeWithRemoval checks whether a string can be a valid palindrome by removing at most one character.
 *
 * <p>This class provides a method to determine if a string can be converted into a valid palindrome by removing at most
 * one character. It uses a two-pointer approach to efficiently check the string for palindrome properties.
 *
 * @author tanmoychakraborty
 */
public class ValidPalindromeWithRemoval {

  /**
   * Checks whether a string can be a valid palindrome by removing at most one character.
   *
   * @param s The input string to check.
   * @return True if the string can be a valid palindrome, false otherwise.
   */
  public static boolean isValidPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        // Try removing one character from either the left or right end and check for palindromes.
        return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
      }
      left++;
      right--;
    }

    // If we've checked the entire string without finding a mismatch, it's a valid palindrome.
    return true;
  }

  /**
   * Helper function to check if a substring is a palindrome.
   *
   * @param s     The input string.
   * @param left  The starting index of the substring.
   * @param right The ending index of the substring.
   * @return True if the substring is a palindrome, false otherwise.
   */
  private static boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    String test1 = "aba";
    String test2 = "abca";
    String test3 = "racecar";
    String test4 = "abcdccxba";

    System.out.println("Test 1: " + isValidPalindrome(test1)); // Output: true
    System.out.println("Test 2: " + isValidPalindrome(test2)); // Output: true
    System.out.println("Test 3: " + isValidPalindrome(test3)); // Output: true
    System.out.println("Test 4: " + isValidPalindrome(test4)); // Output: false
  }
}

