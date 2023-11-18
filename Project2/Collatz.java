// Demonstrates the Collatz conjecture. */
public class Collatz {
	public static void main(String args[]) {
	    int num = Integer.parseInt(args[0]);
	    String mode = args[1];

	    if (mode.equals("v"))
		{

		    for (int i=0;i<num;i++)
		    {
		    	int count = 1;
		    	int seed = i+1;
		    	System.out.print(seed+" ");
		    	while(count==1 || seed != 1)
		    	{
		    		if(seed%2==0)
		    			seed /= 2;
		    		else 
		    			seed = seed*3+1;

		    		count++;
		    		System.out.print(seed+" ");
		    	}
		    	System.out.println("("+count+")");
		    }

		    System.out.print("The first "+num+" hailstone sequences reached 1.");
		}

		else if (mode.equals("c"))
			System.out.print("The first "+num+" hailstone sequences reached 1.");
	}
}