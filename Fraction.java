public class Fraction {	private int denominator;
	private int numerator;
	
	public static Fraction Multiply(Fraction a, Fraction b) {
		return new Fraction(a.numerator * b.numerator, a.denominator*b.denominator);
	}
	public static Fraction Divide(Fraction a, Fraction b) {
		return Multiply(a,b.getReciprocle());
		
	}
	public static Fraction Add(Fraction a, Fraction b) {
		int lcm = (a.denominator*b.denominator)/GCF(a.denominator,b.denominator);
		int factA = lcm/a.denominator;
		int factB = lcm/b.denominator;
		return new Fraction(a.numerator*factA + b.numerator*factB,lcm);
	}
	public static Fraction Subtract(Fraction a, Fraction b) {
		return Add(a, new Fraction(-1*b.numerator,b.denominator));
	}
	public Fraction() {
		denominator = 1;
		numerator = 0;
	}
	public Fraction( int numerator,int denominator) {
		if (denominator == 0) {
			throw new ZeroDenominatorException("NO ZERO!!!!!! :(");
		}
		this.denominator = denominator;
		this.numerator = numerator;
	}
	public Fraction(double num) {
		int fact = 1;
		while ((double)((int)num) != num) {
			num *= 10;
			fact *= 10;
		}
		this.numerator = (int)num;
		this.denominator = fact;
	}
	
	
	public Fraction(String str) {
		if (!str.contains("/")) throw new ZeroDenominatorException("STRING IS NOT A FRACTION!!!!!!! :(");
		int slash = str.indexOf("/");
		int numerator = Integer.valueOf(str.substring(0, slash));
		int denominator = Integer.valueOf(str.substring(slash+1, str.length()));
		if (denominator == 0) {
			throw new ZeroDenominatorException("NO ZERO!!!!!! :(");
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public Fraction(Fraction frac) {
		this.denominator = frac.denominator;
		this.numerator = frac.numerator;
	}
	
	public int getNum() {
		return numerator;
	}
	public int getDenom() {
		return denominator;
	}
	public void setNum(int numerator) {
		this.numerator = numerator;
	}
	public Fraction getReciprocle() {
		return new Fraction(denominator,numerator);
	}
	public void reciprocle() {
		int d = denominator;
		denominator = numerator;
		numerator = d;
	}
	public void setDenom(int denominator) {
		if (denominator == 0) {
			throw new ZeroDenominatorException("I dont like zeros :(");
		}
		this.denominator = denominator;
	}
	public void reduce() {
		int fact = GCF(numerator,denominator);
		denominator /= fact;
		numerator /= fact;
	}
	private static int GCF(int a, int b) {
		int r = a % b;
		while (r != 0){
			a = r;
			r = b % r;
			b = a;
		}
		return b;
	}
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	public double toDouble() {
		return numerator/(double)denominator;
	}
}
