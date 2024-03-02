public class Basic{
  public  static void main(String[] args){
    Pen p1=new Pen();         // create a new object p1  with Pen() constructer
    System.out.println(p1);  // return name of class and address of class 
    p1.setColor("red");
    p1.setPenTip(5);             // update using methods 
    System.out.println(p1.getColor()+" "+p1.getPenTip());
    // p1.color="blue";           // give error in private members 
    // p1.penTip=7;              // update withoud methods
  }
}

class Pen{                  // create a new class named Pen
  private String color;
  private int penTip;

  String getColor(){
    return this.color;
  }
  int getPenTip(){
    return this.penTip;
  }
  void setColor(String color){
    this.color=color;
  }
  void setPenTip(int penTip){
    this.penTip=penTip;
  }
}