/** Tests the representation and handling of expressions.
 */
public class ExpressionTest {

    // The following static fractions and expressions can help you 
    // run some tests of your own. You don't have to use them.

    static final Fraction half =         new Fraction(1,2);
    static final Fraction minusHalf =    new Fraction(-1,2);
    static final Fraction quarter =      new Fraction(1,4);
    static final Fraction minusQuarter = new Fraction(-1,4);
    static final Fraction third =        new Fraction(1,3);
    static final Fraction zero =         new Fraction(0,1);

    static final Expression additionExp =    new Expression(half, quarter, '+');
    static final Expression subtractionExp = new Expression(minusHalf, third, '-');
    static final Expression productExp =     new Expression(quarter, minusHalf, '*');
    static final Expression divisionExp =    new Expression(minusQuarter, minusHalf, ':');
    static final Expression comparisonExp =  new Expression(third, half, '>');

    public static void main(String args[]) {

        testRandomExpression();
        testValue();
        testHint();
    }

    private static void testRandomExpression() {
        System.out.println("Generating 10 random expressions with limit = 7:");
        for(int i = 0; i < 10; i++){
            Expression exp = new Expression(7);
            System.out.println(exp);
        }
        
    }

    private static void testValue() {
        System.out.println("Generating 10 random expressions with limit = 7,");
        System.out.println("and printing their values (which may not be reduced -- that's ok):");
        System.out.println("The values are not reduced, in purpose:");
        for(int i = 0; i < 10; i++){
            Expression exp = new Expression(7);
            System.out.println(exp + " = " + exp.value());
        }
         
    }

    private static void testHint() {
        System.out.println("Generating 10 random expressions with limit = 7,");
        System.out.println("and printing their hints (multiplication expressions have no hints -- that’s ok):");
        for(int i = 0; i < 10; i++){
            Expression exp = new Expression(7);
            System.out.println("the hint for " + exp + " is " + exp.hint());
        }
        System.out.println();
    }
}
