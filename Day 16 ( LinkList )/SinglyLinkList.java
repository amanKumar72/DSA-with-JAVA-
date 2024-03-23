import java.util.LinkedList;

public class SinglyLinkList {
  public class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;
  public static Node tail;
  public static int size;

  // add element in front of ll
  public void addFront(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
      size = 1;
      return;
    }
    newNode.next = head;
    head = newNode;
    size++;
  }

  // add at last
  public void addLast(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
      size = 1;
      return;
    }
    tail.next = newNode;
    tail = newNode;
    size++;
  }

  // print LinkList
  public void print() {
    if (head == null) {
      System.out.println("LinkList is empty");
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println();
  }

  // add at index
  public void add(int indx, int data) {
    if (indx < 0 || indx > size) {
      System.out.println("Invalid Index");
      return;
    }
    if (indx == 0) {
      addFront(data);
      return;
    }
    if (indx == size) {
      addLast(data);
      return;
    }
    Node temp = head, newNode = new Node(data);
    int i = 0;
    while (i < indx - 1) {
      temp = temp.next;
      i++;
    }
    newNode.next = temp.next;
    temp.next = newNode;
    size++;
  }

  // remove from start
  public int removeFront() {
    if (head == null) {
      System.out.println("LinkList is empty");
      return Integer.MIN_VALUE;
    }
    int data = head.data;
    if (head.next == null) {
      head = tail = null;
      size = 0;
      return data;
    }
    head = head.next;
    size--;
    return data;
  }

  // remove from last
  public int removeLast() {
    if (head == null) {
      System.out.println("LinkList is empty");
      return Integer.MIN_VALUE;
    }
    int data = tail.data;
    if (head.next == null) {
      head = tail = null;
      size = 0;
      return data;
    }
    Node temp = head;
    while (temp.next.next != null) {
      temp = temp.next;
    }
    temp.next = null;
    tail = temp;
    size--;
    return data;
  }

  // remove from index
  public int remove(int index) {
    if (head == null) {
      System.out.println("LinkList is empty");
      return Integer.MIN_VALUE;
    }
    if (index < 0 || index >= size) {
      System.out.println("Invalid index");
      return Integer.MIN_VALUE;
    }
    int data;
    if (index == 0) {
      return removeFront();
    }
    if (index == size - 1) {
      return removeLast();
    }

    Node temp = head;
    int i = 0;
    while (i < index - 1) {
      temp = temp.next;
      i++;
    }
    data = temp.next.data;
    temp.next = temp.next.next;
    size--;
    return data;
  }

  // reverse a list
  public void reverse() {
    Node prevNode = null;
    Node currNode = tail = head;
    Node nextNode;
    while (currNode != null) {
      nextNode = currNode.next;
      currNode.next = prevNode;
      prevNode = currNode;
      currNode = nextNode;
    }
    head = prevNode;
  }

  // delete Nth from last
  public int removeNthEnd(int index) {
    index = size - index;
    if (head == null) {
      System.out.println("LinkList is empty");
      return Integer.MIN_VALUE;
    }
    if (index < 0 || index >= size) {
      System.out.println("Invalid index");
      return Integer.MIN_VALUE;
    }
    int data;
    if (index == 0) {
      return removeFront();
    }
    if (index == size - 1) {
      return removeLast();
    }

    Node temp = head;
    int i = 0;
    while (i < index - 1) {
      temp = temp.next;
      i++;
    }
    data = temp.next.data;
    temp.next = temp.next.next;
    size--;
    return data;
  }

  public Node mid(Node head) {
    Node fast;
    Node slow = fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public boolean isPalindrome() {
    if (head == null || head.next == null) {
      return true;
    }
    // step 1 find mid
    Node mid = mid(head);
    // step 2 reverse second half
    Node prev = null;
    Node curr = mid;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    Node left = head, right = prev;
    // compare Ist and IInd halves
    while (right != null) {
      if (left.data == right.data) {
        left = left.next;
        right = right.next;
      } else {
        return false;
      }
    }
    return true;
  }

  // Find is there cycle in a linklist or not
  public boolean isCycle() {
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }

  // Find and remove cycle in a linklist
  public void removeCycle() {
    Node slow = head, fast = head;
    boolean isCycle = false;
    // detect cycle
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        isCycle = true;
        break;
      }
    }
    if (!isCycle) { // if not cyclic
      return;
    }
    // find common point or cyclic point
    slow = head;
    Node prev = null;
    while (slow != fast) {
      slow = slow.next;
      prev = fast;
      fast = fast.next;
    }

    // remove cycle
    prev.next = null;
  }

  // Merged Sort
  public Node getMid(Node head) {
    Node slow = head;
    Node fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public Node merge(Node left, Node right) {
    SinglyLinkList mergedLL = new SinglyLinkList(); // dummy node for the merged linked list
    mergedLL.addFront(-1);
    Node temp = mergedLL.head;
    while (left != null && right != null) {
      if (left.data <= right.data) {
        temp.next = left;
        left = left.next;
        temp = temp.next;
      } else {
        temp.next = right;
        right = right.next;
        temp = temp.next;
      }
    }

    while (left != null) {
      temp.next = left;
      left = left.next;
      temp = temp.next;
    }

    while (right != null) {
      temp.next = right;
      right = right.next;
      temp = temp.next;
    }

    return mergedLL.head.next;
  }

  public Node mergeSort(Node head) {
    // base case
    if (head == null || head.next == null) {
      return head;
    }

    // find mid
    Node mid = getMid(head);
    Node rightHead = mid.next;
    mid.next = null;

    // find right and left sorted lists
    Node left = mergeSort(head);
    Node right = mergeSort(rightHead);

    // merge
    return merge(left, right);
  }

  // Zig Zag LinkList

  public void convertZigZag() {
    // if (size <= 2) {
    // return;
    // }
    // find mid
    Node slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    Node mid = slow;

    // reverse Second Half
    Node curr = mid.next;
    Node prev = null;
    mid.next = null;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    Node right = prev;

    // Alternate merging
    Node left = head, nextL, nextR;
    while (left != null && right != null) {
      nextL = left.next;
      nextR = right.next;
      left.next = right;
      right.next = nextL;
      // update
      left = nextL;
      right = nextR;
    }

  }

  // remove n node after m nodes

  // public void deleteNafterM(int m, int n) {
  // Node prev = null, temp;
  // for (int i = 0; i < size; i++) {
  // for (int j = 0; j < m; j++) {
  // if (prev == null) {
  // prev = head;
  // } else {
  // prev = prev.next;
  // }
  // }
  // temp = prev;
  // for (int k = 0; k < n; k++) {
  // temp = temp.next;
  // }
  // prev.next = temp.next;

  // }
  // }

  public static void main(String[] args) {
    SinglyLinkList ll = new SinglyLinkList();
    // ll.print();
    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addLast(4);
    ll.addLast(5);
    ll.addLast(6);
    ll.addLast(7);
    ll.addLast(8);
    // ll.addLast(3);
    ll.print();
    // System.out.println("Size=" + ll.size);
    // ll.add(2, 3);
    // ll.print();
    // System.out.println("Size=" + ll.size);
    // System.out.println(ll.removeLast() + "is removed");
    // ll.print();
    // System.out.println("Size=" + ll.size);
    // System.out.println(ll.removeLast() + "is removed");
    // ll.print();
    // System.out.println("Size=" + ll.size);
    // System.out.println(ll.remove(2) + "is removed");
    // ll.print();
    // System.out.println("Size=" + ll.size);
    // System.out.println(ll.removeFront());
    // ll.reverse();
    // ll.removeNthEnd(1);
    // System.out.println(ll.isPalindrome());
    // System.out.println(ll.isCycle());
    // ll.head = ll.mergeSort(ll.head);
    // ll.convertZigZag();
    // ll.isPalindrome();
    ll.print();
  }
}