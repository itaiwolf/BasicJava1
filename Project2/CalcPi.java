// Computes an approximation of PI.
public class CalcPi {

    public static void main(String args[]) { 
		
		double sum = 0;
		int n = Integer.parseInt(args[0]);

		for (double i=1;i<(2*n+1);i+=2)
		{
			if(i%4==1)
				sum += 1/i;

			else
				sum -= 1/i;
		}
		
		System.out.println("pi according to Java: " + Math.PI);
		System.out.println("pi, approximated:     " + 4.0 * sum);
	}
}