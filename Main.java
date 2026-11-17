public class Main {
	
	public static void main(String[] args) {
		Fraction frac = new Fraction(1,0);
		System.out.println(frac);
		frac.reduce();
		System.out.println(frac);
	}
}
