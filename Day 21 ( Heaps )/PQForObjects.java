import java.util.*;

public class PQForObjects {
  static class Student implements Comparable<Student>{
    String name;
    int rank;
    public Student(String name,int rank){
      this.name = name;
      this.rank = rank;
    }
    @Override
    public int compareTo(Student s2){
      return this.rank-s2.rank;
    }
  }

  public static void main(String[] args) {
    PriorityQueue<Student> s1 = new PriorityQueue<>();
    s1.add(new Student("B", 2));
    s1.add(new Student("A", 3));
    s1.add(new Student("E", 2));
    s1.add(new Student("C", 1));
    while (!s1.isEmpty()) {
      System.out.print(s1.peek().name + "->" + s1.peek().rank+"\n");
      s1.remove();
    }
  }

}
