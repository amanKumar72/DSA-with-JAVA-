public class Abstraction {
  public static void main(String[] args) {
    Horse horse = new Horse();
    horse.eat();
    horse.walk();
    Maruti car1=new Maruti();
    System.out.println(car1.engine);
  }
}

// Abstraction : hiding all the unnecessary details and showing only the
// important details to the user

// Using Abstract class

abstract class Animal {
  void eat() {
    System.out.println("Eating...");
  }

  abstract void walk();
}

class Horse extends Animal {
  void walk() {
    System.out.println("horse walking...");
  }
}

class chicken extends Animal {
  void walk() {
    System.out.println("chicken walking...");
  }
}

// using interface : interface is like a blueprint of class provide total
// abstraction and also provide a way to implement multiple inheritence

// ex for total inheritence

interface Car {
  int wheels=0;
  int engine=0;

}

class Maruti implements Car{
  public int wheels=4;
  public int engine=300;
}

class Tesla implements Car{
  public int wheels = 4;
  public int engine =500;
}