package helper;

/**
 * LinkedListNode class represents a node in a singly linked list. It contains an integer data
 * value and a reference to the next node in the list.
 *
 * @author tanmoychakraborty
 */
public class LinkedListNode {
  public int data;
  public LinkedListNode next;

  public LinkedListNode() {}

  /**
   * Constructor to initialize a LinkedListNode with the given data.
   *
   * @param data The integer value to be stored in the node.
   */
  public LinkedListNode(int data) {
    this.data = data;
    this.next = null;
  }
}
