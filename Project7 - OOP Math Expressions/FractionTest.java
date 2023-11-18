/** Tests the Fraction and MyMath methods described in Homework 8.
 */
public class FractionTest {

    // Some representative Fraction objects, used in the various tests written in this class.
    static Fraction half = new Fraction(1,2);
    static Fraction minusHalf = new Fraction(-1,2);
    static Fraction quarter = new Fraction(1,4);
    static Fraction minusQuarter = new Fraction(-1,4);
    static Fraction third = new Fraction(1,3);
    static Fraction twoThirds = new Fraction(2,3);
    static Fraction zero = new Fraction(0,1);
    static Fraction frac1 = new Fraction(2557,3701);
    static Fraction frac2 = new Fraction(312,417);


    public static void main(String args[]) {
        ///testFraction();
        testAbs();
        testSignum();
        testConvert();
        testSubtract();
        testCompareTo();
        //testEquals();
        testPow();
        testRandomFraction();
        testCommonDenominator();
        testMax();
        //int gcd = MyMath.gcd(24, 12);
        //System.out.println(gcd);
    }

    private static void testFraction() {
        // Use this function for writing code that creates and manipulates Fraction objects.
        // You can use the static Fraction objects declared above, but make sure to practice  
        // creating some Fraction objects of your own.
    }

    private static void testAbs() {
        System.out.println("Testing the abs function:");
        System.out.println("abs(" + half + ") = " + half.abs());
        // Complete the testing code here.
    }

    private static void testSignum() {
        System.out.println("Testing the signum function:");
        System.out.println("signum(" + zero + "): " + zero.signum());
    }

    private static void testConvert() {
        System.out.println("Testing the convert function:");
        System.out.println("convert(" + minusHalf + "): " + minusHalf.convert());
    }

    private static void testSubtract() {
        System.out.println("Testing the substract function:");
        System.out.println(half.subtract(quarter));
    }

    private static void testCompareTo() {
        System.out.println("Testing the compareTo function:");
        System.out.println(half.compareTo(half));
    }

    private static void testEquals() {
        // Complete the testing code here.
    }

    private static void testPow() {
        System.out.println("Testing the pow function:");
        System.out.println(half.pow(5));
    }

    private static void testRandomFraction() {
        System.out.println("Testing the Random Constructor function:");
        for(int i = 0; i < 5; i++){
            Fraction frac3 = new Fraction(7);
            System.out.println(frac3);
        }
    }

    private static void testCommonDenominator() {
        System.out.println("Testing the CommonDenominator function:");
        System.out.println(MyMath.commonDenominator(quarter, half));
    }

    private static void testMax() {
        System.out.println("Testing the max function:");
        System.out.println(MyMath.max(frac1, frac2));
    }    
}