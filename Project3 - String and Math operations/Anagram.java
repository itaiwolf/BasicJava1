
// A collection of functions for handling anagrams.
public class Anagram {
	public static void main(String args[]) {
	      // Tests the isAnagram function.
   		  System.out.println(isAnagram("ssilent","listen"));  // true
	      System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
	      System.out.println(isAnagram("Madam Curie","Radium came")); // true
	      // Tests the randomAnagram function.
	      
	      System.out.println(preProcess("What? No Way")); 
	      System.out.println(randomAnagram("silent")); // Prints a random anagram

	      // Performs a stress test of randomAnagram
	      boolean pass = true;
	      String str = "this is a stress test";
	      for (int i = 0; i < 1000; i++) {
	          pass = pass && isAnagram(str, randomAnagram(str));	
	      }     
	      System.out.println(pass);	// true if all tests are positive
	   }  

	   // Returns true if the two given strings are anagrams, false otherwise.
	   public static boolean isAnagram(String str1, String str2) {
		   // Replace the return statement with your code.
	   		boolean found;

	   		boolean [] arr = new boolean[str2.length()];
	   		for (int i = 0; i < str2.length(); i++ ){
	   			arr[i] = false;   			
	   		}


	   	    for (int i = 0; i < str1.length(); i++ ){
	   	    	found = false;
	   	    	if(str1.charAt(i) == ' ')
	   	    			i++;

	   	    	for (int j = 0; j < str2.length(); j++ ){
	   	    		if((str1.charAt(i) == str2.charAt(j) || str1.charAt(i) == str2.charAt(j) + 32 ||
	   	    			str1.charAt(i) == str2.charAt(j) - 32) && arr[j] == false)
	   	    	    {
	   	    	    	found = true;
	   	    	    	arr[j] = true;
	   	    	    	j = str2.length();

	   	    	    }
	   	    		
	   	        }

	   	        if(found == false)
	   	    	    return false;
	   	    }

	   	    for (int c = 0; c < str2.length(); c++ ){
	   	    	if(arr[c] == false)
	   	    	{
	   	    		if(str2.charAt(c) != ' ')
	   	    			return false;
	   	    	}   	    	
	   	    }

	       return true;
	   }
	   
	   // Returns a preprocessed version of the given string: all the letter characters
	   // are converted to lower-case, and all the other characters are deleted. For example, 
	   // the string "What? No way!" becomes "whatnoway"
	   public static String preProcess(String str) {
		   // Replace the return statement with your code.
	   		String str2 = "";
	   		for (int i = 0; i < str.length(); i++ ){
	   	    	if(str.charAt(i) >= 65 && str.charAt(i) <= 90)
	   	    	{
	   	    		str2 = str2 + (char)((char)str.charAt(i) + 32);
	   	    	}

	   	    	else if(str.charAt(i) >= 97 && str.charAt(i) <= 122)
	   	    	{
	   	    		str2 = str2 + (char)str.charAt(i);
	   	    	}			
	   		}

	       return str2;
	   } 
	
	 public static String lowercase(String str) {
        //Write your code here:
        char c;
        String str2 = "";
        for(int i = 0; i < str.length() ;i++) 
        {
            c = (char)(str.charAt(i));
            if(c >= 65 && c <= 90)
            { 
                c = (char)(c + 32);
            }

            str2 = (String)(str2 + c);
        }
        

       return str2;
    }
	   
	   // Returns a random anagram of the given string. The random anagram consists of the same
	   // letter characters as the given string, arranged in a random order.
	public static String randomAnagram(String str) {
		   // Replace the return statement with your code.

		String oldAnagram = lowercase(str);
	   	char[] newAnagram = new char[str.length()];                  
	   	
	   	for (int i = 0; i < oldAnagram.length() ;i++){
	        newAnagram[i] = oldAnagram.charAt(i);
	   	}

	   	int place = (int)(Math.random()*oldAnagram.length());
	   	char temp = newAnagram[place];
	   	newAnagram[place] = newAnagram[1];
	   	newAnagram[1] = temp;

	   	String finalAnagram = "";
	   	for (int j = 0; j < oldAnagram.length(); j++ )
	   	{
	   		finalAnagram = finalAnagram + newAnagram[j];	   		
	   	}

	    return finalAnagram;

	   }
	}

	   