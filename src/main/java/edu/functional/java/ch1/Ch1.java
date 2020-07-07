package edu.functional.java.ch1;

public class Ch1 {

  /*
    Ex:1.1
    This program is fully functional
   */
  public static int add(int a, int b) {
    while (b > 0) {
      a++;
      b--;
    }
    return a;
  }

  /*
    the following implementation,although a bit stupid, is functional
   */
  public static int div(int a, int b) {
    return (int) (a / (float) b);
  }


  /*
    Ex:1.5
    Replacing mult(2, 3) and mult(4, 5) with their respective return values doesn’t
    change the signification of the program:
    int x = add(6, 20);
   */

  public static int add2(int a, int b) {
    log(String.format("Returning %s as the result of %s + %s", a + b, a, b));
    return a + b;
  }
  public static int mult(int a, int b) {
    return a * b;
  }

  public static void log(String m) {
    System.out.println(m);
  }

  public static void main(String[] args) {
    int x = add2(mult(2, 3), mult(4, 5));
  }




}
