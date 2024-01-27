package helper;

/**
 * Helper class for printing linked lists with forward arrows.
 *
 * @author tanmoychakraborty
 */
public class PrintList {

  /**
   * Prints the linked list with forward arrows and "null" at the end.
   *
   * @param head The head of the linked list.
   */
  public static void printListWithForwardArrow(LinkedListNode head) {
    LinkedListNode temp = head;

    while (temp != null) {
      System.out.print(temp.data); // print node value
      temp = temp.next;
      if (temp != null) {
        System.out.print(" → ");
      } else {
        // if this is the last node, print " → null" at the end
        System.out.print(" → null \n ");
      }
    }
  }

  /**
   * Prints the linked list with forward arrows.
   *
   * @param head The head of the linked list.
   */
  public static void printListWithForwardArrowLoop(LinkedListNode head) {
    LinkedListNode temp = head;

    while (temp != null) {
      System.out.print(temp.data); // print node value
      temp = temp.next;
      if (temp != null) {
        System.out.print(" → ");
      }
    }
  }
}
