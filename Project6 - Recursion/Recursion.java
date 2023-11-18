import javax.lang.model.util.ElementScanner14;

public class Recursion {
    // For Q8
    public static int steps = 0;

    public static void main(String[] args) {
        //System.out.println(isExist("hello", 'l'));
        //System.out.println(gcd(54, 24));
        //System.out.println(removeVowels("h3ll0 worLD@!@352"));
        //System.out.println(convert(26, 6));
        //System.out.println(camelCaseMain("  hello worLd      hi "));
        //System.out.print("'");
        //System.out.print(makeFirstBig("      "));
        //System.out.print("'");

        //int [] arr = {1, 2, 3, 4, 5};
        //System.out.println(sumArray(arr));

        //System.out.println(binarySearch(arr, 6));

        int [] arr1 = {4, 2, 8};
        int [] arr2 = {4, 2, 8, 7, -1};
        int [] arr3 = {2, 6, 4, 2, 8};
        int [] arr4 = {4, 2, 3, 2, 1};
        int [] arr5 = {4, 2, 3, 2, 8};
        int [] arr6 = {4, 2, 3, 4, 1, 8};
        int [] arr7 = {2, 3, 4, 1, 8};
        int [] arr8 = {4, 4, 2};
        int [] arr9 = {4, 3, 4, 2};
        int [] arr10 = {4, 2, 4, 4};
        int [] arr11 = {4, 2, 4 ,6, 4};

   /*     System.out.println(isSubArr(arr1,arr2));// true
        System.out.println(isSubArr(arr1,arr3));// true
        System.out.println(isSubArr(arr1,arr4));// false
        System.out.println(isSubArr(arr1,arr5));// true
        System.out.println(isSubArr(arr1,arr6));// true
        System.out.println(isSubArr(arr1,arr7));// false
        System.out.println(isSubArr(arr8, arr9));// true
        System.out.println(isSubArr(arr8, arr10));// false
        System.out.println(isSubArr(arr8, arr11));// false   */ 

       // int [][] arr2d = {{3,4,5} , {2,2,0}, {1,0,1}};
        //System.out.println(maxVal(arr2d));
        //System.out.println(effMaxVal(arr2d));

        String s = "    Hello World ahhh Atyu        ";
        System.out.println(camelcase(s));

    }

    public static int gcd (int a, int b){
        if (a > b)
        {
            return gcd(a - b, b);
        }
        else if (a < b)
        {
            return gcd(a, b - a);
        }
        return a;
    }
    public static boolean isExist (String str, char ch){ // "herlo", 'l'
        if(str.length() == 1){
            if(str.charAt(0) == ch){
                return true;
            }
            else{
                return false;
            }      
        } 

        else if(str.charAt(0) == ch){
            return true;
        }

        else 
        {
            return false || isExist(str.substring(1), ch);
        }
    }

    public static String removeVowels (String str){
        if(str.length() == 1){
           if(isExist("aeiouAEIOU" ,str.charAt(0))){
                return "";
           }
           else{
                return str;
           }
        }  

        else if(isExist("aeiouAEIOU", str.charAt(0)))
        {
            return "" + removeVowels(str.substring(1));
        }

        else{
            return str.charAt(0) + removeVowels(str.substring(1));
        }
    }

    public static String convert (int num, int base){
        if(num < base){
            String s = "";
            return s + num;
        }   

        else {
            return convert((num / base), base) + (num % base);
        }
    }
 
    public static String lowerCase (String s){
        if(s.length() == 1){ // אם זאת אות גדולה - תקטין אותה
            if(s.charAt(0) <= 90 && s.charAt(0) >= 65){
                return "" + (char)(s.charAt(0) + 32);
            }
            else{
                return "" + (char)(s.charAt(0));
            }       
        }
        
        else if(s.charAt(0) <= 90 && s.charAt(0) >= 65){
            return (char)(s.charAt(0) + 32) + lowerCase(s.substring(1));
        }
        
        return (char)(s.charAt(0)) + lowerCase(s.substring(1));
    }
 

    public static String camelcaseHelper (String sentence){
        if(sentence.length() == 1){
            return camelcaseMain(sentence);
        }

        if(sentence.charAt(0) == ' '){
            return camelcaseHelper(sentence.substring(1));
        }

        return (char)(sentence.charAt(0) - 32) + camelcaseMain(sentence.substring(1));      
    }

    public static String camelcaseMain (String sentence){
        if(sentence.length() == 1){
            String s = "";
            if(sentence.charAt(0) != ' '){
                return s + sentence.charAt(0);
            }
            return s;
        }

        else if (sentence.charAt(0) == ' '){
            //System.out.println("'" + sentence);
            return camelcaseHelper(sentence.substring(1));            
        }           
        
        return sentence.charAt(0) + camelcaseMain(sentence.substring(1));
            
    }

    public static String camelcase (String sentence){
        sentence = lowerCase(sentence);
        sentence = camelcaseMain(sentence);
        if(sentence.charAt(0) >= 65 && sentence.charAt(0) <= 90){
            char ch = sentence.charAt(0);
            ch = (char)(ch + 32);
            String s = ch + sentence.substring(1);
            return s;
        }   
        return sentence;
    }
    
    public static int sumArr (int [] arr){
        return sumArr(arr, arr.length - 1);
    }
    public static int sumArr (int [] arr, int n){
        if(n == 0){
            return arr[0];
        }
        else {
            return arr[n] + sumArr(arr, n - 1);
        }
    }

    public static int binarySearch (int [] sortedArr, int value){
        int low = 0;
        int high = sortedArr.length - 1;
        return binarySearch(sortedArr, value, low, high);
    }

    public static int binarySearch (int [] sortedArr, int value, int low, int high){
        if(low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        if(value == sortedArr[mid]){
            return mid;
        }
        
        else if(sortedArr[mid] > value){
            return binarySearch(sortedArr, value, low, mid - 1);
        }

        else {
            return binarySearch(sortedArr, value, mid + 1, high);
        }
    }
       
    

    public static boolean isSubArr(int[] arr1, int[] arr2) {
        return isSubArr(arr1, arr2, 0, 0, 0);
    }

    public static boolean isSubArr (int [] smaller, int [] bigger, int index1, int index2, int startPoint){
        //if -> true case
        if (index1 == smaller.length) {
            return true;
        }

        //if -> false case
        if (startPoint > bigger.length - smaller.length + 1){
            return false;
        }
        
        if(index2 == bigger.length){
            return false;
        }

        if (smaller[index1] == bigger[index2]) {
            return isSubArr(smaller, bigger, index1 + 1, index2 + 1, startPoint);
        }

        return isSubArr(smaller, bigger, index1, index2 + 1, startPoint);
    }

    public static void mainQuestion8() {
        // Put your testing code here. For example:
        int[][] a = { {3, 4, 5},
                      {2, 2, 0},
                      {1, 0, 1} };
        System.out.println(" Value of maximal path = " + maxVal(a)); 
        System.out.println(" Number of recursive steps = " + steps);
        steps = 0;                       
        System.out.println(" Value of maximal path = " + effMaxVal(a)); 
        System.out.println(" Number of recursive steps = " + steps);
    }

    // Returns the value of the maximal path in the given 2D array
    public static int maxVal(int[][] arr) {
        return maxVal(arr, 0, 0);
    }
    
    // Returns the value of the maximal path in the given 2D array, starting at location (i,j)
    private static int maxVal(int[][] arr, int i, int j) {
        steps++;
        if(i == arr.length -1 && j == arr[0].length - 1){
            return arr[i][j];
        }
        
        else if(i == arr.length -1 && j != arr[0].length - 1){
            return arr[i][j] + maxVal(arr, i, j + 1);
        }

        else if(i != arr.length -1 && j == arr[0].length - 1){
            return arr[i][j] + maxVal(arr, i + 1, j);
        }

        return arr[i][j] + Math.max(maxVal(arr, i, j + 1), maxVal(arr, i + 1, j)) ;

    }
    
    // Returns the value of the maximal path in the given 2D array, efficiently.
    public static int effMaxVal(int[][] arr) {
        // Creates a 2D array named memo, of the same dimensions as arr.
        // This array will be used for memorizing maxVal computations.
        // After creating the memo array, initializes all its elements to -1.
        // Next, initializes the value of the bottom-right cell of memo to the 
        // value of the bottom-right (destination) cell of arr.

        // Put the array creation and initialization code here:
        int [][] memo = new int[arr.length][arr[0].length];
        for(int i = 0; i < memo.length; i++){
            for(int j = 0; j < memo[0].length; j++){
                memo[i][j] = -1;
            }
        }

        memo[memo.length - 1][memo[0].length - 1] = arr[memo.length - 1][memo[0].length - 1];
        
        // Computes the value of the maximal path, using the memo array: 
        effMaxVal(arr, 0, 0, memo);
        // The maximal value is now stored in memo[0][0]:
        return memo[0][0];
    }
    
    // Returns the value of the maximal path in the given 2D array, starting
    // at location (i,j), efficiently. By "efficiently" we mean as follows:
    // If the value was already computed, returns the value using memo.
    // Otherwise, computes the value, stores the value in memo,
    // and returns the value.
    // SIDE EFFECT: This function changes the contents of the given memo array.
    private static int effMaxVal(int[][] arr, int i, int j, int[][] memo) {
        steps++;
        if(i == arr.length -1 && j == arr[0].length - 1){
            return arr[i][j];
        } 
        else if(i == arr.length -1 && j != arr[0].length - 1){
            if(memo[i][j] != -1){
                return memo[i][j];
              }   
              else{
                 memo[i][j] = arr[i][j] + effMaxVal(arr, i, j + 1, memo);
                 return memo[i][j];
              }
        }
        else if(i != arr.length -1 && j == arr[0].length - 1){
            if(memo[i][j] != -1){
                return memo[i][j];
              }
            
              else{
                 memo[i][j] = arr[i][j] + effMaxVal(arr, i + 1, j, memo);
                 return memo[i][j];
              }
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }      
        memo[i][j] = arr[i][j] + Math.max(effMaxVal(arr, i, j + 1, memo), effMaxVal(arr, i + 1, j, memo)) ;
        return memo[i][j];
        
        }
    }

