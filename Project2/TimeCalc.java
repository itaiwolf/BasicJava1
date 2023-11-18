public class TimeCalc {

	public static void main(String[] args) {
		// In Java, the command-line arguments args[0], args[1], ... are represented
		// each by a string. In this program, the single "hh:mm" input is represented
		// by the single command-line string argument args[0]. 
		//   
		// Concatenates the empty string "" with the left hour-digit, concatenates
		// the resulting string with the right hour-digit, and casts the resulting
		// string as an int.
		int hours = Integer.parseInt("" + args[0].charAt(0) + args[0].charAt(1));
		// Does the same with the minute digits.
		int minutes = Integer.parseInt("" + args[0].charAt(3) + args[0].charAt(4));
        // Complete the program's code here:
        //int output = Integer.parseInt(args[0]);

        if (hours<0 || hours>23 || minutes<0 || minutes>60)
        	System.out.println("Invalid input"); 
        
        else
        {

        int change = Integer.parseInt(args[1]);
        if (change>0) 
        {
        	hours += change/60;
        	minutes += change%60;
        	if(minutes>=60)
        	{
        		minutes -= 60;
        		hours += 1;
        	}
        	
        	while(hours>23)
        	{
        		hours -= 24;
        	}
        	
        }

        else if (change<0) 
        {
        	hours += change/60;
        	minutes += change%60;
        	if(minutes<0)
        	{
        		minutes += 60;
        		hours -= 1;
        	}

        	while(hours<0)
        	{
        		hours += 24;
        	}
        		
        }


        if (hours >= 13)
        {  
        	System.out.print(hours-12);
        }

   		else if (hours < 10)
   		{
   			System.out.print(hours);
   		}

   		else if (hours >= 10 && hours < 13) 
   		{
   			System.out.print(hours);	
   		}
       
        System.out.print(":");

		if (minutes<10)
		{
			System.out.print("0"+minutes);
		}

		else 
			System.out.print(minutes);
   		
        if (hours < 12) 
        {
        	System.out.print(" AM");
        }
  		
  		else if (hours >= 12)
  	    {
  			System.out.print(" PM ");

        }
    }

    }
}
