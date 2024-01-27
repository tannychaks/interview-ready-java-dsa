package week_2.topic2_fast_and_slow_pointers;

import static helper.PrintList.printListWithForwardArrow;
import static helper.PrintList.printListWithForwardArrowLoop;

import helper.CustomLinkedList;
import helper.LinkedListNode;

/**
 * The CycleDetection class provides a method to detect a cycle in a linked list.
 * It uses the Floyd's Tortoise and Hare algorithm to determine if there is a cycle
 * in the linked list.
 *
 * @author tanmoychakraborty
 */
class CycleDetection {

  /**
   * Detects a cycle in a given linked list.
   *
   * @param head The head of the linked list to check for a cycle.
   * @return True if a cycle is detected, false otherwise.
   *
   * @TimeComplexity O(N), where N is the number of nodes in the linked list.
   * @SpaceComplexity O(1), as it uses constant extra space for two pointers.
   */
  public static boolean detectCycle(LinkedListNode head) {
    if (head == null) {
      return false;
    }

    // Initialize two pointers, slow and fast, to the head of the linked list
    LinkedListNode slow = head;
    LinkedListNode fast = head;

    // Run the loop until we reach the end of the linked list or find a cycle
    while (fast != null && fast.next != null) {
      // Move the slow pointer one step at a time
      slow = slow.next;
      // Move the fast pointer two steps at a time
      fast = fast.next.next;

      // If there is a cycle, the slow and fast pointers will meet
      if (slow == fast) {
        return true;
      }
    }

    // If we reach the end of the linked list and haven't found a cycle, return False
    return false;
  }

  // Driver code
  public static void main(String[] args) {
    int[][] input = { { 2, 4, 6, 8, 10, 12 }, { 1, 3, 5, 7, 9, 11 },
        { 0, 1, 2, 3, 4, 6 }, { 3, 4, 7, 9, 11, 17 }, { 5, 1, 4, 9, 2, 3 } };
    int[] pos = { 0, -1, 1, -1, 2 };

    for (int i = 0; i < input.length; i++) {
      CustomLinkedList<Integer> list = new CustomLinkedList<>();
      list.createLinkedList(input[i]);
      System.out.print(i + 1 + ".\tInput:");
      System.out.print("\t");
      if (pos[i] == -1) {
        printListWithForwardArrow(list.head);
      } else {
        printListWithForwardArrowLoop(list.head);
      }
      System.out.println("\n\tpos: " + pos[i]);

      if (pos[i] != -1) {
        int length = list.getLength(list.head);
        LinkedListNode lastNode = list.getNode(list.head, length - 1);
        lastNode.next = list.getNode(list.head, pos[i]);
      }

      System.out.println("\n\tDetected Cycle =  " + detectCycle(list.head));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}

