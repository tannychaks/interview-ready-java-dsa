package helper;

/**
 * CustomLinkedList class represents a generic linked list and provides methods for creating,
 * inserting nodes at the head, getting the node at a specific position, and getting the length of
 * the linked list.
 *
 * @param <T> The type of data stored in the linked list.
 * @author tanmoychakraborty
 */
public class CustomLinkedList<T> {

  public LinkedListNode head;

  /**
   * Constructor to initialize an empty linked list.
   */
  public CustomLinkedList() {
    this.head = null;
  }

  /**
   * Inserts a new node at the head of the linked list.
   *
   * @param node The node to be inserted at the head.
   */
  public void insertNodeAtHead(LinkedListNode node) {
    if (this.head != null) {
      node.next = this.head;
    }
    this.head = node;
  }

  /**
   * Creates a linked list from an array of integers by inserting each element at the head of the
   * linked list.
   *
   * @param list The array of integers used to create the linked list.
   */
  public void createLinkedList(int[] list) {
    for (int i = list.length - 1; i >= 0; i--) {
      LinkedListNode newNode = new LinkedListNode(list[i]);
      insertNodeAtHead(newNode);
    }
  }

  /**
   * Returns the node at the specified position (index) of the linked list.
   *
   * @param head The head of the linked list.
   * @param pos  The position (index) of the desired node.
   * @return The node at the specified position.
   */
  public LinkedListNode getNode(LinkedListNode head, int pos) {
    LinkedListNode ptr = head;
    if (pos != -1) {
      int p = 0;

      while (p < pos) {
        ptr = ptr.next;
        p += 1;
      }

      return ptr;
    }
    return ptr;
  }

  /**
   * Returns the number of nodes in the linked list.
   *
   * @param head The head of the linked list.
   * @return The number of nodes in the linked list.
   */
  public int getLength(LinkedListNode head) {
    LinkedListNode temp = head;
    int count = 0;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    return count;
  }
}
