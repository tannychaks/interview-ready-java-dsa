package week_2.topic1_two_pointers;

/**
 * Given a sentence, reverse the order of its words without affecting the order of letters within a
 * given word.
 * <p>
 * Constraints:
 * - Sentence contains English uppercase and lowercase letters, digits, and spaces.
 * - The order of the letters within a word is not to be reversed.
 * <p>
 * Note: The input string may contain leading or trailing spaces or multiple spaces between words.
 * The returned string, however, should only have a single space separating each word. Do not include
 * any extra spaces.
 * <p>
 * Time Complexity: O(n)
 * - n is the length of the input string.
 * - Traversing the string twice: once to reverse the whole string and once to reverse each word.
 * <p>
 * Space Complexity: O(n)
 * - Additional space is used to store the intermediate string and StringBuilder.
 *
 * @author tanmoychakraborty
 */
public class ReverseWordsInString {

  /**
   * Reverses the order of words in a sentence while preserving the order of letters within each word.
   *
   * @param s The input sentence to be reversed.
   * @return The reversed sentence.
   */
  public static String reverseWords(String s) {
    // trim spaces and convert string to string builder
    char[] s1 = s.toCharArray();
    String s2 = trimSpaces(s1, s1.length);
    StringBuilder builder = new StringBuilder(s2);

    // reverse the whole string using the strRev() function
    strRev(builder, 0, builder.length() - 1);

    // reverse every word
    int n = builder.length();
    int start = 0, end = 0;
    // Find the start index of each word by detecting spaces.
    while (start < n) {
      // Find the end index of the word.
      while (end < n && builder.charAt(end) != ' ')
        ++end;
      // Let's call our helper function to reverse the word in-place.
      strRev(builder, start, end - 1);
      // moving to the next word
      start = end + 1;
      ++end;
    }

    return builder.toString();
  }

  /**
   * Reverses a string from startRev to endRev in-place.
   *
   * @param sb        The StringBuilder containing the string to be reversed.
   * @param startRev  The starting index of the substring to be reversed.
   * @param endRev    The ending index of the substring to be reversed.
   * <p>
   * Time Complexity: O(endRev - startRev)
   * - The method reverses a substring of the input string within the specified range.
   *   The time complexity depends on the length of the substring to be reversed.
   */
  public static void strRev(StringBuilder sb, int startRev, int endRev) {
    // Starting from the two ends of the list, and moving
    // in towards the centre of the string, swap the characters
    while (startRev < endRev) {
      char temp = sb.charAt(startRev); // temp store for swapping
      sb.setCharAt(startRev++, sb.charAt(endRev));
      sb.setCharAt(endRev--, temp);
    }
  }


  /**
   * Trims leading, trailing, and multiple spaces in a string.
   *
   * @param a   The character array representing the input string.
   * @param n   The length of the input string.
   * @return    The trimmed string.
   */
  static String trimSpaces(char[] a, int n) {
    // Convert character array to string
    String str = new String(a, 0, n);

    // Trim extra spaces at the beginning and end of the string
    // And replace multiple spaces with a single space
    str = str.replaceAll("\\s+", " ").trim();

    return str;
  }

  // Driver code
  public static void main(String[] args) {
    String[] inputs = {
        "Hello World", "We love Python",
        "The quick brown fox jumped over a lazy dog.",
        "Hey", "To be or not to be", "AAAAA", " Hello     World "};

    for (int i = 0; i < inputs.length; i++) {
      System.out.print(i + 1);
      System.out.println(".\tActual string:\t\t" + inputs[i]);
      System.out.println("\tReversed String:\t" + reverseWords(inputs[i]));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}
