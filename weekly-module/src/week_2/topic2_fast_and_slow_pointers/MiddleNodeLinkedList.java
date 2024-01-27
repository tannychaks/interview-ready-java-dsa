package week_2.topic2_fast_and_slow_pointers;

import static helper.PrintList.printListWithForwardArrow;

import helper.CustomLinkedList;
import helper.LinkedListNode;

/**
 * This class demonstrates the usage of the slow and fast pointer technique to find the middle node
 * of a linked list.
 * <p>
 * The slow and fast pointers are used to traverse the linked list. The slow pointer moves one step
 * at a time, while the fast pointer moves two steps at a time. When the fast pointer reaches the
 * end of the list (or null), the slow pointer will be at the middle node of the linked list.
 * <p>
 * Time Complexity: O(N), where N is the number of nodes in the linked list.
 * <p>
 * Space Complexity: O(1), as we are using constant extra space for the slow and fast pointers.
 *
 * @author tanmoychakraborty
 */
public class MiddleNodeLinkedList {

  /**
   * Function to find the middle node of the linked list.
   *
   * @param head The head of the linked list.
   * @return The middle node of the linked list.
   */
  public static LinkedListNode middleNode(LinkedListNode head) {

    // Create two pointers, slow and fast, initially pointing to the head
    LinkedListNode slow = head;
    LinkedListNode fast = head;

    // Traverse the linked list until fast reaches the last node or NULL
    while (fast != null && fast.next != null) {

      // Move the slow pointer one step ahead
      slow = slow.next;

      // Move the fast pointer two steps ahead
      fast = fast.next.next;
    }

    // Return the slow pointer (the middle node)
    return slow;
  }

  /**
   * Main method to test the middleNode function.
   *
   * @param args Command line arguments (not used in this program).
   */
  public static void main(String[] args) {

    // Input test cases: arrays representing linked lists
    int[][] input = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}, {3, 2, 1}, {10}, {1, 2}};

    // Iterate through the input test cases
    for (int i = 0; i < input.length; i++) {
      System.out.print(i + 1);
      CustomLinkedList<Integer> list = new CustomLinkedList<>();
      list.createLinkedList(input[i]);
      System.out.print(".\tInput linked list:  ");
      printListWithForwardArrow(list.head);
      System.out.print("\tMiddle of the linked list is:  ");
      System.out.println(middleNode(list.head).data);
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}
