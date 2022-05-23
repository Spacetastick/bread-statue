//most of this code is copied from the textbook since I was just supposed to change the implementation to work with biginteger

package chapter13;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise13_15 {

	@SuppressWarnings("serial")
	static class Rational extends Number implements Comparable<Rational> {
		  // Data fields for numerator and denominator
		  private BigInteger numerator = new BigInteger("0");
		  private BigInteger denominator = new BigInteger("1");

		  /** Construct a rational with default properties */
		  public Rational() {
		    this(new BigInteger("0"), new BigInteger("1"));
		  }

		  /** Construct a rational with specified numerator and denominator */
		  public Rational(BigInteger numerator, BigInteger denominator) {
		    BigInteger gcd = gcd(numerator, denominator);
		    this.numerator = (denominator.compareTo(new BigInteger("0")) > 0 ? new BigInteger("1") : new BigInteger("-1")).multiply(numerator).divide(gcd);
		    this.denominator = denominator.abs().divide(gcd);
		  }

		  /** Find GCD of two numbers */
		  private static BigInteger gcd(BigInteger n, BigInteger d) {
		    BigInteger n1 = n.abs();
		    BigInteger n2 = d.abs();
		    BigInteger gcd = new BigInteger("1");
		    
		    for (int k = 1; k <= n1.intValue() && k <= n2.intValue(); k++) {
		      if (n1.intValue() % k == 0 && n2.intValue() % k == 0) 
		        gcd = BigInteger.valueOf(k);
		    }

		    return gcd;
		  }

		  /** Return numerator */
		  public BigInteger getNumerator() {
		    return numerator;
		  }

		  /** Return denominator */
		  public BigInteger getDenominator() {
		    return denominator;
		  }

		  /** Add a rational number to this rational */
		  public Rational add(Rational secondRational) {
		    BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
		    BigInteger d = denominator.multiply(secondRational.getDenominator());
		    return new Rational(n, d);
		  }

		  /** Subtract a rational number from this rational */
		  public Rational subtract(Rational secondRational) {
		    BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
		    BigInteger d = denominator.multiply(secondRational.getDenominator());
		    return new Rational(n, d);
		  }

		  /** Multiply a rational number to this rational */
		  public Rational multiply(Rational secondRational) {
		    BigInteger n = numerator.multiply(secondRational.getNumerator());
		    BigInteger d = denominator.multiply(secondRational.getDenominator());
		    return new Rational(n, d);
		  }

		  /** Divide a rational number from this rational */
		  public Rational divide(Rational secondRational) {
		    BigInteger n = numerator.multiply(secondRational.getDenominator());
		    BigInteger d = denominator.multiply(secondRational.numerator);
		    return new Rational(n, d);
		  }

		  @Override // Override toString()
		  public String toString() {
		    if (denominator.equals(BigInteger.valueOf(1)))
		      return numerator + "";
		    else
		      return numerator + "/" + denominator;
		  }

		  @Override // Override the equals method in the Object class 
		  public boolean equals(Object other) {
		    if ((this.subtract((Rational)(other))).getNumerator().equals(BigInteger.valueOf(0)))
		      return true;
		    else
		      return false;
		  }

		  @Override // Implement the abstract intValue method in Number 
		  public int intValue() {
		    return (int)doubleValue();
		  }

		  @Override // Implement the abstract floatValue method in Number 
		  public float floatValue() {
		    return (float)doubleValue();
		  }

		  @Override // Implement the doubleValue method in Number 
		  public double doubleValue() {
		    return numerator.intValue() * 1.0 / denominator.intValue();
		  }

		  @Override // Implement the abstract longValue method in Number
		  public long longValue() {
		    return (long)doubleValue();
		  }

		  @Override // Implement the compareTo method in Comparable
		  public int compareTo(Rational o) {
		    if (this.subtract(o).getNumerator().compareTo(BigInteger.valueOf(0)) > 0)
		      return 1;
		    else if (this.subtract(o).getNumerator().compareTo(BigInteger.valueOf(0)) < 0)
		      return -1;
		    else
		      return 0;
		  }
		}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the first rational number: ");
		Rational first = new Rational(new BigInteger(console.next()), new BigInteger(console.next()));
		System.out.print("Enter the second rational number: ");
		Rational second = new Rational(new BigInteger(console.next()), new BigInteger(console.next()));
		
		System.out.println(first + " + " + second + " = " + first.add(second));
		System.out.println(first + " - " + second + " = " + first.subtract(second));
		System.out.println(first + " * " + second + " = " + first.multiply(second));
		System.out.println(first + " / " + second + " = " + first.divide(second));
		System.out.println(second + " is " + second.doubleValue());
	}
	
}
