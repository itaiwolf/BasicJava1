/** A library of commonly used mathematical operations.
 */
public class MyMath {

    // For each one of the three method names listed below, 
    // write the method signature, document the method,
    // and write its implementation.
    // The documentation should be done in JavaDoc.
    // Use the same documentation style we used in Fraction.java. 

    /** gcd */
    static int gcd(int x, int y) {

        while (y != 0) {
            int rem = x % y;
            x = y;
            y = rem;     
        }
        return x;
    }
    /** commonDenominator */
    static int commonDenominator(Fraction first, Fraction second) {
        if(first.getDenominator() % second.getDenominator() == 0){
            return first.getDenominator();
        }

        else if(second.getDenominator() % first.getDenominator() == 0){
            return second.getDenominator();
        }
        
        return first.getDenominator() * second.getDenominator();
    }
    

    /** max */
    public static Fraction max(Fraction first, Fraction second) { // האם צריך לצמצם את השבר המקסימלי?
        int commonDem = commonDenominator(first, second);
        int num1 = first.getNumerator() * (commonDem / first.getDenominator());
        int num2 = second.getNumerator() * (commonDem / second.getDenominator());
        System.out.println(first.getNumerator());
        if(num1 > num2){
            return new Fraction(first.getNumerator(), first.getDenominator());
        }

        else {
            return new Fraction(second.getNumerator(), second.getDenominator());
        }            
    }

}