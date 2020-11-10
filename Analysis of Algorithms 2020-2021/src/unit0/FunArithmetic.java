//Noah Cil
package unit0;

public class FunArithmetic {

  public static int add(int a, int b) {
	  //TODO write code that returns a + b
	  return a + b;
  }

  public static int subtract(int a, int b) {
	  //TODO write code that returns a - b
	  return a - b;
  }

  public static int multiply(int a, int b) {
	  // TODO write code that returns a * b
	  return a * b;
  }

  public static void main(String[] code) {
	  int a = 3, b = 2;
	  System.out.println("a + b = " + add(a, b));
	  System.out.println("a - b = " + subtract(a, b));
	  System.out.println("a * b = " + multiply(a, b));
  }
  
}