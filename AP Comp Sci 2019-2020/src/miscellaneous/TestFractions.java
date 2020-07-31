package miscellaneous;

// Chapter 10 Questions 6 and 22

public class TestFractions
{
  public static void testConstructors()
  {
    Fraction f1 = new Fraction();
    Fraction f2 = new Fraction(10);
    Fraction f3 = new Fraction(5, -30);
    Fraction f4 = new Fraction(f3);

    System.out.println("f1 = " + f1);
    System.out.println("f2 = " + f2);
    System.out.println("f3 = " + f3);
    System.out.println("f4 = " + f4);
    System.out.println();
  }

  public static void testArithmetic()
  {
    Fraction f1 = new Fraction(1, 2);
    Fraction f2 = new Fraction(1, 3);

    Fraction sum = f1.add(f2);
    System.out.println(f1 + " + " + f2 + " = " + sum);

    Fraction diff = f1.subtract(f2);
    System.out.println(f1 + " - " + f2 + " = " + diff);

    Fraction product = f1.multiply(f2);
    System.out.println(f1 + " * " + f2 + " = " + product);

    Fraction ratio = f1.divide(f2);
    System.out.println(f1 + " / " + f2 + " = " + ratio);

    System.out.println();
  }

  /*
  public static void testValues()
  {
    double x = 0.375;
    Fraction f = Fraction.valueOf(x);
    System.out.println(f.getValue() + " = " + f);
    System.out.println();
  }
  */
  
  public static void main(String[] args)
  {
    testConstructors();
    testArithmetic();
    //testValues();
  }
}


/*f1 = 0/1
f2 = 10/1
f3 = -1/6
f4 = -1/6

1/2 + 1/3 = 5/6
1/2 - 1/3 = 1/6
1/2 * 1/3 = 1/6
1/2 / 1/3 = 3/2

0.375 = 3/8
*/