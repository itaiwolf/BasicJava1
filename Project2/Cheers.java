public class Cheers {
    public static void main(String[] args) {
   	    // Complete the program code here:
        String word = args[0];
        int num = Integer.parseInt(args[1]);
        for (int i=0; i<word.length(); i++) 
        {
            char ch = word.charAt(i);
            if(ch == 'A' || ch == 'E'|| ch == 'I' || ch == 'O' ||  ch == 'U'
            || ch == 'a' || ch == 'e'|| ch == 'i' || ch == 'o' || ch == 'u')
            {
                System.out.println("Give me an "+ch+": "+ch+"!");
            }

            else
            {
                System.out.println("Give me a "+ch+": "+ch+"!");
            }     
        }

        System.out.println("What does that spell?");
        for (int i=0; i<num; i++)
        {
            System.out.println(word+"!!!");    
        }

    }
}