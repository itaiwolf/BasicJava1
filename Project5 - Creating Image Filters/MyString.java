/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        System.out.println(MyString.countChar("stapler",'s'));
        System.out.println(MyString.subsetOf("jim","dwight"));
        System.out.println(MyString.subsetOf("word","world"));
        System.out.println(MyString.subsetOf("spa","space"));
        System.out.println(MyString.subsetOf("pass","space"));
        System.out.println(MyString.subsetOf("pasess","spaces"));
        System.out.println(MyString.subsetOf("c","space"));
        System.out.println("..." + MyString.spacedString("dunder") + "...");
        System.out.println(MyString.randomStringOfLetters(3));
        System.out.println(MyString.remove("space","ace"));
        System.out.println(MyString.remove("committee","meet"));
        System.out.println(MyString.remove("pass","ass"));

        System.out.println(toLowerCase("ABC"));
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length() ; i++ ) {
             if (str.charAt(i) == c)
             {
                count++;
             }       
        }
        return count;
    }

    /** Returns true if str1 is a subset string str2, false otherwise.
     *  For example, "spa" is a subset of "space", and "pass" is not
     *  a subset of "space".
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        boolean [] arr = new boolean [str2.length()];
        for (int i = 0; i < str1.length() ;i++ ){
            boolean exist = false;
            for (int j = 0; j < str2.length() ;j++ ){
                if(str1.charAt(i) == str2.charAt(j) && arr[j] == false)
                {
                    arr[j] = true;
                    exist = true;
                    break;
                }
            }
            if (!exist)
            {
                return false;
            }
        }

        return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for last character of the string, that has no space after it. 
     * Example: if str is "silent", returns "s i l e n t".
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String s = "";
        for (int i = 0; i < str.length() ;i++ ) {
            if(i != str.length() - 1)
            {   
                s = s + str.charAt(i) + " ";
            }

            else 
            {
                s = s + str.charAt(i);
            }
        }
        return s;
    }

    public static String toLowerCase(String str) {
        String s = "";
        for (int i = 0; i < str.length() ;i++ ) {
            s = s + (char)(str.charAt(i) + 32);
        }
        return s;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String str = "";
        for (int i = 0; i < n ;i++ ) {
            int rand = (int)(97 + Math.random() * 26);
            str += (char)(rand);
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: "committee" minus "meet" returns "comit". 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        char [] arr = new char[str1.length()];
        for (int i = 0; i < str1.length() ;i++ ) {
            arr[i] = str1.charAt(i);    
        }

        for (int j = 0; j < str2.length() ;j++ ) {
            for (int k = 0; k < arr.length ;k++ ) {
                 while(str2.charAt(j) != arr[k] || arr[k] == -1){
                    k++;
                }   

                arr[k] = '1';  
                break;          
            }
        }

        String s = "";
        for (int l = 0; l < arr.length ;l++ ) {
            if(arr[l] != '1')
            {
                s += arr[l];
            }         
        }

        return s;
    
    }

}
