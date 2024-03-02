public class Polymorphism {
  public static void main(String[] args) {
    Calculator calc = new Calculator();
    System.out.println(calc.sum(5, 9));
    System.out.println(calc.sum(5.6f, 9.4f));
    System.out.println(calc.sum(5, 9, 3));

    Fish f1 = new Fish();
    f1.eat();
  }
}

// Polymorphism: do similar things in different forms

// Method Overlodding multiple functions with same name but different parameters
class Calculator {
  int sum(int a, int b) {
    return a + b;
  }

  float sum(float a, float b) {
    return a + b;
  }

  int sum(int a, int b, int c) {
    return a + b + c;
  }
}

// method overriding parent-> class have same functions then the function of
// child will be executes

class Animal {
  Animal() {
    System.out.println("Animal constructor called ");
  }

  void eat() {
    System.out.println("Eating...");
  }

  void breathe() {
    System.out.println("Breathing...");
  }
}

class Fish extends Animal {
  int fins;

  Fish() {
    System.out.println("Fish constructor called ");
  }

  void swim() {
    System.out.println("Swimming...");
  }

  void eat() {
    System.out.println("Fish Eating...");
  }

}