/*** you may only use the following String functions
1.  str.charAt(int i);
2.  str.length();
3.  str.substring(int start);
4.  str.substring(int start,int end);
*/
public class StringOps {
    public static void main(String[] args) {
        //System.out.println(trim("aaaaahappy birthdayaaaa",'a'));
        //System.out.println(trim("aaaahappy birthdayaaaa",'b'));

        String [] arr1 = tokenize(" x + Math.sqrt(x) - rate ");
        String [] arr = tokenize(" R U N I");
        for (int i = 0; i < arr.length ;i++ ) {
            System.out.print(arr[i]+" , ");  // {“x”, “+”, “Math.sqrt(x)”,”-“,”rate”} 
        }
        System.out.println(" ");
        //System.out.println(arr.length); // 5
        //System.out.println(lastIndexOf("abccb",'c')); // -1 ); // 0 );
        //System.out.println(toBinary(6));
    
}

 public static String lowercase(String str) {
        //Write your code here:
        char c;
        String str2 = "";
        for(int i = 0; i < str.length() ;i++) {
            c = (char)(str.charAt(i));
            if(c >= 65 && c <= 90)
            { 
                c = (char)(c + 32);
            }

            str2 = (String)(str2 + c);
        }
        

       return str2;
    }
    
    public static String trim(String str,char ch) {
        int i = 0;
        int j = str.length()-1;
        if(str.charAt(0)==ch)
        {
            while(str.charAt(i)==ch)
            {
                i++;
            }
        }

        if(str.charAt(j)==ch)
        {
           while(str.charAt(j)==ch)
            {
                j--;
            } 
        }

        String newS = str.substring(i, j + 1);

        return newS;
    }

    public static int lastIndexOf(String str, char ch) {
        for (int i = str.length() -1 ; i > -1  ; i--) {
            if(str.charAt(i) == ch)
                return i;
        }
        return -1;
    }

    public static String toBinary (int x){
        String s = " ";
        while(x != 0){
            s = x % 2 + s;
            x = x / 2;
        }
        return s;
    }

    public static String [] tokenize(String str) {
        int j = 0;
        str = trim(str,' ');

        String [] strArr = new String[str.length()];
        int a = 0;
        for (int i = 0; i < str.length() ;i++ ) {
                j = i;
                while(str.charAt(j) != ' '){
                    if(j + 1 == str.length())
                    {
                        break;
                    }
                    else
                    {
                       j++;  
                    }
                }  

                if(j + 1 == str.length())
                {
                    String s = str.substring(i);
                    strArr[a] = s;
                    a++;                     
                }

                else
                {
                    String s = str.substring(i,j);
                    strArr[a] = s;
                    a++; 
                }
                
                while(str.charAt(j) == ' '){
                    j++;
                }  

                if(j + 1 == str.length()){
                    break;
                }
                else
                {
                    i = j;
                    i--;
                }
        }

        String [] finalArr = new String[a];
        for (int f = 0; f < a ;f++ ) {
            finalArr[f] = strArr[f];
        }
        return finalArr;
    }
}


