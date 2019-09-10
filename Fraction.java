public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(String fraction) {
        int i = 0;
        while (fraction.charAt(i) != '/')
            i++;
        numerator = Integer.valueOf(fraction.substring(0, i));
        denominator = Integer.valueOf(fraction.substring(i + 1));
    }

    public Fraction FractionAdd(Fraction fraction) {
        int n = numerator * fraction.denominator + denominator * fraction.numerator;
        int d = denominator * fraction.denominator;
        int gcd = gcd(Math.min(n, d), Math.max(n, d));
        return new Fraction(n/gcd, d/gcd);
    }

    public Fraction FractionSubtract(Fraction fraction) {
        int n = numerator * fraction.denominator - denominator * fraction.numerator;
        int d = denominator * fraction.denominator;
        int gcd = gcd(Math.min(n, d), Math.max(n, d));
        return new Fraction(n/gcd, d/gcd);
    }

    public Fraction FractionMultiply(Fraction fraction) {
        int n = numerator * fraction.numerator;
        int d = denominator * fraction.denominator;
        int gcd = gcd(Math.min(n, d), Math.max(n, d));
        return new Fraction(n / gcd, d / gcd);
    }

    public Fraction FractionDivide(Fraction fraction) {
        int n = numerator * fraction.denominator;
        int d = denominator * fraction.numerator;
        int gcd = gcd(Math.min(n, d), Math.max(n, d));
        return new Fraction(n / gcd, d / gcd);
    }

    // sigfigs
    public double toDecimal() {
        return (double) (numerator) / denominator;
    }

    public int compareTo(Fraction fraction) {
        int n = numerator * fraction.denominator;
        int d = fraction.numerator * denominator;
        if (d > n)
            return 1;
        if (d < n)
            return -1;
        else
            return 0;
    }

    public int gcd(int x, int y) {
        int a = y / x;
        int b = y % x;
        if (b == 0)
            return x;
        else
            return gcd(b, x);
    }

    public String toString() {
        return numerator + " / " + denominator;
    }
}