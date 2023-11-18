// Represents some code operations as functions.
public class CodeOps {
	public static void main(String args[]) {
	    // Some tests of the class functions

	    int [] res = (frequencies("As Easy as A, B, C"));
	    /*for (int i = 0; i < res.length ;i++ ) {
	    	System.out.print(res[i]+" ");
	    }*/
	    System.out.println(" ");

	    printHistogram(frequencies("As Easy as A, B, C"));

	    System.out.println(encode("defend the northern wall", 4)); // “hijirh xli rsvxlivr aepp” );
	    System.out.println(decode("hijirh xli rsvxlivr aepp", 4));

	}  

	public static int[] frequencies(String str) {
		int [] res = new int [26]; // Alphabet size.
		str = StringOps.lowercase(str);
		for (int i = 0; i < str.length(); i++ ) {

			if(str.charAt(i) >= 97 && str.charAt(i) <= 122)
			{
				int index = (str.charAt(i) - 97);
				res[index]++; 
			}			
		}
	    return res;
	}

	public static void printHistogram(int[] letters) {
		for (int i = 0; i < letters.length ;i++ ) {
			System.out.print((char)(i + 97) + ": ");
			for (int j = 0; j < letters[i] ;j++ ) {
				System.out.print("*");
			}
			System.out.println(" ");
			
		}
	}

	// assumption: the key is bigger or equal to -26
	public static String encode(String str, int key) {
		str = StringOps.trim(str,' ');
		String str2 = "";
		int n = ' ';
		for (int i = 0; i < str.length(); i++ ) {
			if(str.charAt(i) >= 97 && str.charAt(i) <= 122)
			{
				n = (str.charAt(i) - 97);
				n = n + key;
				if(n >= 0)
				{
					n = n % 26;	
				}

				else
				{
					n = n % 26;
					n = n + 26;	
				}
				
				n = n + 97;				

				str2 += (char)n;
			}

			else if(str.charAt(i) == 32)
			{
				str2 += ' ';
			}
		}
	    return str2;
	}

	public static String decode(String str, int key) {
		key = -1 * key;
	    return encode(str, key);
	}

	public static String decode(String str) {
		
	    return "";
	}
}
