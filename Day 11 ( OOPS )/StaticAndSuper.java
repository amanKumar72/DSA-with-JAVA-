public class StaticAndSuper {
  public static void main(String[] args) {
    Student s1 = new Student();
    Student s2 = new Student();
    s1.collegeName = "RDEC";  // Student.collegeName="RDEC" is the way to  do it
    s1.name = "aman";
    s2.name = "vibhor";
    System.out.println(s1.collegeName);
    System.out.println(s1.code);
  }
}

class College {
  int code;
  String address;
}

class Student extends College {
  String name;
  static String collegeName;
  // constructor

  Student() {
    super.address = "India";
    this.code = 101;
  }
}
