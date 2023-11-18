public class StringOps {
    public static void main(String[] args) {

        System.out.println(charRunCount("abc", 'c'));
        System.out.println(lowercase("Hello World"));
        System.out.println(camelcase("   Hello World   "));

        System.out.println(compareTo("abc", "abc"));
        System.out.println(compareTo("abc", "ABC"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abc", "abd"));
        System.out.println(compareTo("abc", "abac"));
        System.out.println(compareTo("abc", "ab"));

        System.out.println(stringToInt("+70350"));
        System.out.println(stringToInt("-70350"));
        System.out.println(stringToInt("70350"));

        System.out.println(expand("G11C4D7"));
        
        

        //System.out.println(compareTo("abc","abc"));
        
    }

    public static int charRunCount(String str, char c) {
        // Write your code here:
        
        int count = 0;
        for (int i=0; i<str.length() ;i++ ) {
            if(str.charAt(i)==c){
                count++;
            }
        }

        return count;
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

    //System.out.println(lowercase("Hello World"));

    

    public static String camelcase(String str){

        String s = "";
        for (int i = 0;i < str.length() ;i++ ){
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90)
            s = s + (char)(str.charAt(i)+32);

            else if(str.charAt(i) != ' ')
            {
                s = s + str.charAt(i);  
            }

            else if(str.charAt(i) == ' ')
            {
                while(str.charAt(i) == ' ')
                {
                    if(i != str.length() - 1)
                        i++;

                    else 
                        break;
                }


                if(s == "")
                {
                    if(str.charAt(i) >= 65 && str.charAt(i) <= 90) 
                    {
                         s = s + (char)(str.charAt(i)+32);
                    } 
                    else if (str.charAt(i) >= 97 && str.charAt(i) <= 122)
                    {
                         s = s + (char)(str.charAt(i));
                    }

                }


                else if(str.charAt(i) >= 97 && str.charAt(i) <= 122)
                {
                    s = s + (char)(str.charAt(i) - 32);
                }

                else if(str.charAt(i) >= 65 && str.charAt(i) <= 90)  
                {
                    s = s + (char)(str.charAt(i));
                }             
            }
            
        }
        return s;
    }

    public static int compareTo(String str1, String str2) {
        // Write your code here:
        if(str1 == str2)
        {
            return 0;
        }
        else
        {
            int min = Math.min(str1.length(), str2.length());
            for (int i = 0; i < min ;i++){
                if(str1.charAt(i) != str2.charAt(i) && str1.charAt(i) != str2.charAt(i) + 32 &&
                   str1.charAt(i) != str2.charAt(i) - 32)
                {
                    if(str1.charAt(i) < str2.charAt(i))
                        return -1;

                    if(str1.charAt(i) > str2.charAt(i))
                        return 1;

                }
            }

            if(str1.length() < str2.length()){
                return -1; 
            }
                    
            else if(str1.length() > str2.length()){
                  return 1; 
            }
                  
        }
        return 0;
    }


    public static int stringToInt(String str){
        // Write your code here:
        int num = 0;
        int i = 0;
            
        if(str.charAt(i) == '+'){
            for (i = 1; i < str.length() ;i++ ){
                num = num + (str.charAt(i) - 48);  
                num = num * 10;          
            }
         }

        else if(str.charAt(i) == '-'){
            for (i=1; i<str.length() ; i++ ){
                num = num + (str.charAt(i) - 48); 
                num = num * 10;             
            }
            num = -num;
        }

        else
        {
            for (i=0; i<str.length() ;i++){
                num = num + ((int)str.charAt(i) - 48);   
                num = num * 10;       
            }
        }
        return num / 10;
    }


  public static String expand(String str) {
        // Write your code here:
        
        String newStr = "";
        String subStr = "";
        int repeats = 0;
        int k = 1;

        for (int i = 0; i < str.length(); i++ ){   
            
            k = i+1;
            while(str.charAt(k) >= 48 && str.charAt(k) <= 57){
                if(k+1 == str.length() || str.charAt(k+1) < 48 || str.charAt(k+1) > 57)
                {
                    break;
                }

                else
                {
                    k++;
                }
            }

            subStr = str.substring(i + 1,k + 1); 
            repeats = Integer.parseInt(subStr); 

            for (int j = 0; j < repeats ;j++ ) {
                newStr = newStr + str.charAt(i);
            }

            if (k+1 != str.length()){
                i = k;
            }  

            else if(k+1 == str.length()){
                return newStr;
            }      
        }
        return newStr;
    }
}



