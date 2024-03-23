public class DoublyLL {
  public class Node {
    int data;
    Node prev, next;

    public Node(int data) {
      this.data = data;
      this.next = this.prev = null;
    }
  }

  public static Node head;
  public static Node tail;
  public static int size;

  // add at front
  public void addFirst(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head =tail= newNode;
      return;
    }

    newNode.next = head;
    head.prev = newNode;
    head = newNode;
    size++;

  }

  // remove from front 
  public int removeFirst(){
    if(head==null){
      System.out.println("DLL is empty");
      return Integer.MIN_VALUE;
    }
    int data=head.data;
    if(head.next==null){
      head=tail=null;
      size=0;
      return data;
    }

    head=head.next;
    head.prev=null;
    size--;
    return data;
  }

  public void print() {
    if (head == null) {
      System.out.println("LinkList is empty");
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "<->");
      temp = temp.next;
    }
    System.out.println();
  }

  // reverse a linklist
  public void reverse(){
    Node prev=null,curr=tail=head,next;
    while(curr!=null){
      next=curr.next;
      curr.next=prev;
      curr.prev=next;
      prev=curr;
      curr=next;
    }
    head=prev;
  }

  public static void main(String[] args) {
    DoublyLL DLL = new DoublyLL();
    DLL.print();
    DLL.addFirst(5);
    DLL.addFirst(4);
    DLL.addFirst(3);
    DLL.addFirst(2);
    DLL.addFirst(1);
    DLL.removeFirst();
    DLL.print();
    DLL.reverse();
    DLL.print();
  }
}
