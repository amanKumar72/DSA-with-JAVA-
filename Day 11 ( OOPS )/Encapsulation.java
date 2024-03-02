public class Encapsulation {
  public static void main(String[] args) {
    Animal a=new Animal();
    a.breathe();
  }
}



// Encapsulation : the wrapping up of data and methods under a single unit. It
// also implements data hiding.
//

class Animal {
  void eat() {
    System.out.println("Eating...");
  }

  void breathe() {
    System.out.println("Breathing...");
  }
}
