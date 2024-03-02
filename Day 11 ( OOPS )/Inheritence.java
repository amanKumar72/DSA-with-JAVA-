
public class Inheritence {
  public static void main(String[] args) {
    Animal A = new Fish(); // we can make parent reference = new child obj
    A.eat(); // accesable
    // A.walk(); // not accesable
    Dog d1 = new Dog(); // callling of constructors base class constructor-> derived class constructor
                        // -> derived class constructor

  }

}

// base class
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

// child classes Single inheritence: base class->derived class
class Fish extends Animal {
  int fins;

  void swim() {
    System.out.println("Swimming...");
  }
}

// hierarcial inheritence : base class extends into different more than one
// classes
class Mammals extends Animal {
  int legs;

  Mammals() {
    System.out.println("Mammals constructor called ");
  }

  void walk() {
    System.out.println("Walking...");
  }
}

class Birds extends Animal {
  int wings;

  void fly() {
    System.out.println("Flying...");
  }
}

// multiple inheritence : base class->derived class-> derived class
// hybrid inheritence : multiple + hierarcial
class Human extends Mammals {
  void talks() {
    System.out.println("talking...");
  }
}

class Dog extends Mammals {
  Dog() {
    System.out.println("Dog constructor called ");
  }

  void bark() {
    System.out.println("barking...");
  }
}