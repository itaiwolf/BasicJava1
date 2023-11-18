public class ArrayOps {
    public static void main(String[] args) {

        int [] arr1 = {2, 8, 3, 7, 8};
        int [] arr2 = {11, 9, 8, 9, 10};
        int [] arr3 = {8,9,8,9,10};
        //System.out.println(sumArray(arr2)); // 6 
        //System.out.println(isSorted(arr2));
        //System.out.println(bruteForce(arr2,1));
        //System.out.println(findMissingInt(arr3));
        System.out.println(secondMaxValue(arr1));
        //int [] arr = (merge(arr1, arr2));
        /*for (int i = 0; i < arr.length ;i++ ) {
             System.out.print(arr[i]+" ");
        }*/
        //System.out.println(binarySerach(arr3, 1)); 
        int [] unionset = union(arr1, arr2);
        for (int i = 0; i < unionset.length ;i++ ) {
             System.out.print(unionset[i]+" ");
        }

       

    }

    public static int secondMaxValue(int [] array) { // 2, 8, 3, 7, 8
        int max = maxValue(array); // 8
        boolean found = false;
        int j = 0;
        int [] newArr = new int[array.length - 1]; // new arr: 2, 3, 7, 
        for (int i = 0; i < array.length ;i++ ) {
            if(array[i] == max && found == false){
                found = true;
            }
            
            else if(array[i] != max || found == true){
                newArr[j] = array[i];
                j++;
            }
        }

        for (int i = 0; i < newArr.length ;i++ ) {
             System.out.print(newArr[i]+" ");

        }
         System.out.println();
        
        max = maxValue(newArr);

        return max;
    }

    public static int sumArray(int [] array) {
        int sum = 0;
        for (int i = 0; i < array.length ;i++ ) {
            sum += array[i];
        }
        return sum;
    }

    public static boolean isSorted(int [] array) {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1 ;i++ ) {
            if(array[i] > array[i+1])
            {
                sorted = false;
                break;
            }
        }

        return sorted;
    }

    public static int bruteForce (int [] array, int value){
        
        for (int i = 0; i < array.length ;i++ ) {
            if(array[i] == value)
            {
                return i;
            }
        }

        return -1;
    }
    
    public static int binarySerach (int [] array, int value){
        int i = 0;
        int j = array.length - 1;
        int k = 0;

        while(k < array.length / 2 + 1){
            if(array[i] == value)
            {
                return i;
            }

            else if(array[j] == value)
            {
                return j;
            }

            else 
            {
                if(array[((i+j) / 2)] == value)
                {
                    return ((i+j) / 2);
                }
                
                else if(array[(i+j) / 2] < value)
                {
                    i = ((i+j) / 2);
                }

                else if(array[(i+j) / 2] > value)
                {
                    j = ((i+j) / 2);
                }

            }

            k++;
        }

        return -1;

    }

    public static int maxValue(int [] array) {
        int max = array[0];
        for (int i = 0; i < array.length ;i++ ) {
            if(array[i] > max)
            {
                max = array[i];
            }
        }

        return max;
    }

    public static int minValue(int [] array) {
        int min = array[0];
        for (int i = 0; i < array.length ;i++ ) {
            if(array[i] < min)
            {
                min = array[i];
            }
        }

        return min;
    }

    

    public static int secondMinValue(int [] array) {
        int min = minValue(array);
        int max = maxValue(array);
        int i = 0;

        while(array[i] != min){
            i++;
        }

        array[i] = max;

        min = minValue(array);

        return min;
    }

    public static int findMissingInt (int [] array){
        int sum = sumArray(array);
        int genericSum = 0;
        for (int i = 0; i < array.length + 1 ;i++ ) {
            genericSum += i;
        }

        return genericSum - sum;

    }


    public static int[] merge(int [] array1,int [] array2) {
        int [] mergedArr = new int[array1.length + array2.length];
        int k = 0;
        for (int i = 0; i < array1.length ;i++ ) {
            mergedArr[i] = array1[i];
            k++;
        }

        for (int j = 0; j < array2.length ;j++ ) {
            mergedArr[k] = array2[j];
            k++;
        }

        mergedArr = SetOps.orderArr(mergedArr);
       
        
        return mergedArr;
    }

    /** Returns the union of the two sets.
 *   The union of set1 and set2 is the set containing all the elements of set1
 *   and all the elements of set2 that are not elements of set1. */
    public static int[] setOfUnique(int[] set1, int[] set2) {
        int [] setOfUnique = new int [set1.length + set2.length];
        int j = 0;
        for (int i = 0; i < set2.length ;i++ ) {
            if(SetOps.contains(set1, set2[i]) == false)
            {
                setOfUnique[j] = set2[i];
                j++;
            }
        }

        setOfUnique = SetOps.trimArr(setOfUnique);
        return setOfUnique;
    }

    public static int[] union(int[] set1, int[] set2) {
        int [] arrOfUnique = setOfUnique(set1, set2); // 237
        int [] unionArr = new int [set1.length + arrOfUnique.length]; // length = 6
        for (int i = 0; i < set1.length ;i++ ) {
            unionArr[i] = set1[i];
        }

        System.out.println(" ");
        int k = set1.length;
        for (int j = 0; j < arrOfUnique.length ;j++ ) {
            unionArr[k] = arrOfUnique[j];
            k++;
        }

        

        return unionArr;

    }


}


