public  class  TestRandom {
	static int a = 0;
	public static void main(String[]  args) {
		// Complete the program code here:
		int n = Integer.parseInt(args[0]);
		int countBig = 0;
		int countSmall = 0;
		

		for (int i = 0; i < n; i++) 
		{
			double x = Math.random();
			if(x>0.5)
				countBig++;
			else 
				countSmall++;
		}

		System.out.println("> 0.5: "+countBig+" times.");
		System.out.println("<= 0.5: "+countSmall+" times.");
		System.out.println("ratio: "+(double)countBig/countSmall);
	}
}