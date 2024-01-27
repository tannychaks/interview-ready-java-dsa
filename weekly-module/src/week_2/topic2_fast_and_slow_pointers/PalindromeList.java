package week_2.topic2_fast_and_slow_pointers;

import static helper.LinkedListReversal.reverseLinkedList;
import static helper.PrintList.printListWithForwardArrow;

import helper.CustomLinkedList;
import helper.LinkedListNode;

/**
 * The PalindromeList class provides a method to determine if a linked list is a palindrome.
 * A linked list is considered a palindrome if its values form a palindrome sequence.
 *
 * @author tanmoychakraborty
 */
public class PalindromeList {

  /**
   * Checks if a given linked list is a palindrome.
   *
   * @param head The head of the linked list to check.
   * @return True if the linked list is a palindrome, false otherwise.
   *
   * @TimeComplexity O(N), where N is the number of nodes in the linked list.
   * @SpaceComplexity O(1), as it uses constant extra space to compare the linked list in-place.
   */
  public static boolean palindrome(LinkedListNode head) {
    LinkedListNode slow = head;
    LinkedListNode fast = head;

    // Find the middle of the linked list
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Reverse the second half of the linked list in-place
    LinkedListNode reversedSecondHalf = reverseLinkedList(slow);

    // Compare the first half and the reversed second half of the linked list
    boolean isPalindrome = compareTwoHalves(head, reversedSecondHalf);

    // Restore the linked list to its original state
    reverseLinkedList(reversedSecondHalf);

    return isPalindrome;
  }

  /**
   * Compares two halves of a linked list for equality.
   *
   * @param firstHalf The head of the first half of the linked list.
   * @param secondHalf The head of the reversed second half of the linked list.
   * @return True if the two halves are equal, false otherwise.
   */
  public static boolean compareTwoHalves(LinkedListNode firstHalf, LinkedListNode secondHalf) {
    while (firstHalf != null && secondHalf != null) {
      if (firstHalf.data != secondHalf.data) {
        return false;
      } else {
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
      }
    }
    return true;
  }

  // Driver code
  public static void main(String[] args) {
    int[][] input = {
        {2, 4, 6, 4, 2},
        {0, 3, 5, 5, 0},
        {9, 27, 4, 4, 27, 9},
        {5, 4, 7, 9, 4, 5},
        {5, 10, 15, 20, 15, 10, 5}
    };

    for (int i = 0; i < input.length; i++) {
      System.out.print(i + 1);
      CustomLinkedList<Integer> list = new CustomLinkedList<>();
      list.createLinkedList(input[i]);
      System.out.print(".\tLinked list:  ");
      printListWithForwardArrow(list.head);
      System.out.print("\tIs it a palindrome?  ");
      boolean result = palindrome(list.head);
      if (result) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}
