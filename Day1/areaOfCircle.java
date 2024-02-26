import java.util.*;

public class areaOfCircle {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("enter Radius= ");
    float r = sc.nextFloat();
    System.out.print("Area= "+r*r*3.14f);
    // float area = 3.14f * r * r; //f is used to define that 3.14 is flout otherwise it consider it as double
    // System.out.println(area);
    
    sc.close();
  }
}
