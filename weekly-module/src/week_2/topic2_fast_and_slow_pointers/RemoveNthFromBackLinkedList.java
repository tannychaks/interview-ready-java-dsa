package week_2.topic2_fast_and_slow_pointers;

import static helper.PrintList.printListWithForwardArrow;

import helper.CustomLinkedList;
import helper.LinkedListNode;

/**
 * This class demonstrates the usage of the slow and fast pointer technique to remove the nth node
 * from the end of a linked list.
 * <p>
 * The slow and fast pointers are used to traverse the linked list. The fast pointer is advanced by
 * 'n' nodes ahead of the slow pointer. When the fast pointer reaches the end of the list, the slow
 * pointer will be at the node just before the nth node from the end. This allows us to easily
 * remove the nth node.
 * <p>
 * Time Complexity: O(N), where N is the number of nodes in the linked list.
 * <p>
 * Space Complexity: O(1), as we are using constant extra space for the slow and fast pointers.
 *
 * @author tanmoychakraborty
 */
public class RemoveNthFromBackLinkedList {

  public static void main(String[] args) {
    CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
    customLinkedList.createLinkedList(new int[]{1, 2, 3, 4, 5});

    System.out.println("********************");
    System.out.println("| Given Linked list |");
    System.out.println("********************");
    printListWithForwardArrow(customLinkedList.head);

    int n = 2;
    System.out.print("Nth Node to remove from end : " + n + " \n");
    customLinkedList.head = removeNthFromEnd(customLinkedList.head, n);

    System.out.println("********************");
    System.out.println("| New Linked list |");
    System.out.println("********************");
    printListWithForwardArrow(customLinkedList.head);
  }

  /**
   * Removes the nth node from the end of the linked list.
   *
   * @param head The head of the linked list.
   * @param n    The position of the node to remove from the end.
   * @return The head of the updated linked list.
   */
  private static LinkedListNode removeNthFromEnd(LinkedListNode head, int n) {
    LinkedListNode start = new LinkedListNode();
    start.next = head;
    LinkedListNode slow = start, fast = start;

    // Move the fast pointer 'n' nodes ahead
    for (int i = 0; i < n; i++) {
      if (fast == null) {
        // Handle the case where 'n' is out of bounds
        System.out.println("Provided value of N is out of bounds.");
        return head; // No change to the linked list
      }
      fast = fast.next;
    }

    // Move both pointers until the fast pointer reaches the end
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    // Remove the nth node from the end
    slow.next = slow.next.next;
    return start.next;
  }
}
