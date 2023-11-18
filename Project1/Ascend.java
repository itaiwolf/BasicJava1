// Generates three integer random numbers in a given range,
// and prints them in increasing order.
public class Ascend {
	public static void main(String[] args) {
		// Complete the program's code here:
		int n = Integer.parseInt(args[0]);
		int a = (int)(Math.random()*n);
		int b = (int)(Math.random()*n);
		int c = (int)(Math.random()*n);

		System.out.println(a+" "+b+" "+c);

		int min1 = (int) (Math.min(a,b));
		int min2 = (int) (Math.min(min1,c));
		int max1 = (int) (Math.max(a,b));
		int max2 = (int) (Math.max(max1,c));
		int middle = a+b+c-min2-max2; 

		System.out.println(min2+" "+middle+" "+max2);
	}
}