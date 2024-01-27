package helper;

/**
 * The LinkedListReversal class provides a static method to reverse a linked list.
 *
 * @author tanmoychakraborty
 */
public class LinkedListReversal {

  /**
   * Reverses a given linked list and returns the new head of the reversed list.
   *
   * @param slowPtr The head of the linked list to be reversed.
   * @return The new head of the reversed linked list.
   *
   * @TimeComplexity O(N), where N is the number of nodes in the linked list.
   * @SpaceComplexity O(1), as it uses constant extra space to reverse the list in place.
   */
  public static LinkedListNode reverseLinkedList(LinkedListNode slowPtr) {
    LinkedListNode prev = null;    // Initialize the previous node as null
    LinkedListNode next;
    LinkedListNode curr = slowPtr; // Initialize the current node as the head of the list

    // Traverse the linked list and reverse each node's 'next' pointer
    while (curr != null) {
      next = curr.next;    // Store the next node to avoid losing reference
      curr.next = prev;    // Reverse the 'next' pointer to point to the previous node
      prev = curr;         // Move the 'prev' pointer one step ahead
      curr = next;         // Move the 'curr' pointer one step ahead
    }

    return prev; // Return the new head of the reversed linked list
  }
}

