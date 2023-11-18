// Represents algebraic operations as functions.
public class PrimeOps {
	public static void main(String args[]) {
	    // Some tests of the class functions
	    int [] finalArr = seive(40);
	    for (int i = 0; i < finalArr.length ;i++ ) {
	    	System.out.print(finalArr[i] + " ");
	    }

	}  

	// Returns an array of all prime numbers up to any given number.
	// Assumption: n is nonnegative.
	public static int[] seive(int n){
		int [] primeArray = new int[n/2];
		boolean prime = true;
		int arrIndex = 0;

		for (int i = 2; i < n + 1; i++ ){
			prime = true;
			for (int j = 2; j < (int)Math.sqrt(i) + 1 ; j++ ){
				if(i % j == 0)
				{
					prime = false;
					break; 
				}

			}

			if (prime == true)
			{
				primeArray[arrIndex] = i;
				arrIndex++;
			}
			
		}

		int p = 0;
		while(primeArray[p] != 0){
			p++;
		}

		int [] finalArr = new int [p];
		finalArr[0] = 2;
		
		for (int f = 1; f < p; f++ ){
			finalArr[f] = primeArray[f];
			
		}

		return finalArr;
	}
}
