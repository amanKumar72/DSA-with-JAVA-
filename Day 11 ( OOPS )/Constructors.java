
public class Constructors {
  public static void main(String[] args) {

    Student s1 = new Student();// Not parameterised constructor
    // Student s2 = new Student("Aman");// parameterised constructor
    s1.name = "aman";
    s1.rollNo = 5;
    s1.marks[0] = 100;
    s1.marks[1] = 80;
    s1.marks[2] = 10;

    System.out.println("Before Chainging Marks ");
    System.out.println("Details of Student 1");
    System.out.println(s1.name);
    System.out.println(s1.rollNo);
    for (int i = 0; i < s1.marks.length; i++) {
      System.out.println(s1.marks[i]);
    }

    Student s3 = new Student(s1);

    System.out.println("Details of Student 3");
    System.out.println(s3.name);
    System.out.println(s3.rollNo);
    for (int i = 0; i < s3.marks.length; i++) {
      System.out.println(s3.marks[i]);
    }
    System.out.println("After Chainging Marks ");
    s1.marks[2] = 90;

    System.out.println("Details of Student 1");
    System.out.println(s1.name);
    System.out.println(s1.rollNo);
    for (int i = 0; i < s1.marks.length; i++) {
      System.out.println(s1.marks[i]);
    }

    System.out.println("Details of Student 3");
    System.out.println(s3.name);
    System.out.println(s3.rollNo);
    for (int i = 0; i < s3.marks.length; i++) {
      System.out.println(s3.marks[i]);
    }

  }

}

class Student {
  String name;
  int rollNo;
  int marks[];

  // Student(Student s) { // shallow copy constructo
  // marks=new int[3];
  // this.name = s.name;
  // this.rollNo = s.rollNo;
  // this.marks=s.marks;
  // }
  Student(Student s) { // shallow copy constructor
    marks = new int[3];
    this.name = s.name;
    this.rollNo = s.rollNo;
    for (int i = 0; i < s.marks.length; i++) {
      marks[i] = s.marks[i];
    }
  }

  Student(String name) {
    marks = new int[3];
    this.name = name;
  }

  Student(int rollNo) {
    marks = new int[3];
    this.rollNo = rollNo;
  }

  Student() {
    marks = new int[3];
    System.out.println("Stdent Created...");
  }
}