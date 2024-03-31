import java.util.*;
public class usingTwoStack {
  // add in O(n) remove in O(1)
  public static class Queue1{
    Stack<Integer>s1=new Stack<>();
      Stack<Integer>s2=new Stack<>();
      //isEmpty
      public boolean isEmpty(){
        return s1.isEmpty();
      }
      // add
      public void add(int n){
        while(!s1.isEmpty()){
          s2.push(s1.pop());
        }
        s1.push(n);
        while(!s2.isEmpty()){
          s1.push(s2.pop());
        }
      }
      // remove
      public int remove(){
        if(s1.isEmpty()){
          System.out.println("Queue is empty");
          return -1;
        }
        return s1.pop();
      }
      public int peek(){
        if(s1.isEmpty()){
          System.out.println("Queue is empty");
          return -1;
        }
        return s1.peek();
      }
    }
    
    // add in O(1) remove in O(n)
    public static class Queue2{
      Stack<Integer>s1=new Stack<>();
      Stack<Integer>s2=new Stack<>();
      //isEmpty
      public boolean isEmpty(){
        return s1.isEmpty();
      }
      // add
      public void add(int n){
        s1.push(n);
      }
      // remove
      public int remove(){
        if(s1.isEmpty()){
          System.out.println("Queue is empty");
          return -1;
        }
        while(!s1.isEmpty()){
          s2.push(s1.pop());
        }
        int data=s2.pop();
        while(!s2.isEmpty()){
          s1.push(s2.pop());
        }
        return data;
      }
      public int peek(){
        if(s1.isEmpty()){
          System.out.println("Queue is empty");
          return -1;
        }
        while(!s1.isEmpty()){
          s2.push(s1.pop());
        }
        int data=s2.peek();
        while(!s2.isEmpty()){
          s1.push(s2.pop());
        }
        return data;
      }
    }
  public static void main(String[] args) {
    Queue2 q = new Queue2();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    while (!q.isEmpty()) {
      System.out.println(q.remove());

    }
  }
  
}
