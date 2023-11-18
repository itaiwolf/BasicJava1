
// Represents the hh:mm time format using an AM/PM format. 
public class TimeFormat {

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
        if (hours >= 13) {  
        	System.out.print(hours-12);
        }
   		else if (hours < 10){
   			System.out.print(args[0].charAt(1));
   		}
   		else if (hours >= 10 && hours < 13) {
   			System.out.print(hours);	
   		}
       
        System.out.print(":");

		if (minutes<10)
			System.out.print("0"+minutes);
		else 
			System.out.print(minutes);
   		
        if (hours < 12) 
        	System.out.print("AM");
        }
  		
  		else if (hours >= 12) {
  			System.out.print("PM ");
        }

    }
}

