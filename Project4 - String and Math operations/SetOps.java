public class SetOps {
    public static void main(String[] args) {
        int [] arr1 = {1,3,5};
        int [] arr2 = {3,4};
        int [] arr3 = {1,2,3};
        /*System.out.println(contains(arr1,1,0));
        System.out.println(contains(arr2,1,4));
        System.out.println(contains(arr3,4,2));*/
        //System.out.println(uniqueElements(arr3));
        //int [] distinctArr = buildSet(arr3);
        //int [] symDiffSet = symDiffSets(arr1, arr2);
        /*for (int i = 0; i < symDiffSet.length ;i++ ) {
            System.out.print(symDiffSet[i]+" ");
        }*/
/*
        int [] intersectionArr = intersectionSets(arr1, arr3);
        for (int i = 0; i < intersectionArr.length ;i++ ) {
            System.out.print(intersectionArr[i]+" ");
        }
*/
        int [] diffSet = diffSets(arr1, arr2);
        for (int i = 0; i < diffSet.length ;i++ ) {
            System.out.print(diffSet[i]+" ");
        }


    }

    public static boolean contains(int [] array, int value) {
        boolean found = false;
        for (int i = 0; i < array.length ;i++ ) {
            if(array[i] == value)
                return true;
        }
        return false;
    }

    public static boolean contains(int [] array, int value, int index) {
        for (int i = 0; i < index ;i++ ) {
             if(array[i] == value)
                return true;
        }
        return false;
    }

    public static int uniqueElements (int [] array){
        int [] uniqueArr = new int [array.length];
        int numOfUniques = 0;
        int j = 0;
        for (int i = 0; i < array.length ;i++ ) {
             if(contains(uniqueArr, array[i]) == false)
             {
                uniqueArr[j] = array[i];
                j++;
                numOfUniques++;
             }
                
        }
        return numOfUniques;
    }

    public static int [] buildSet(int [] array) {
        int [] distinctArr = new int[uniqueElements(array)];
        int j = 0;
        for (int i = 0; i < array.length ;i++ ) {
             if(!contains(distinctArr, array[i]))
             {
                distinctArr[j] = array[i];
                j++;
             }        
        }

        return distinctArr;
    }

    public static int [] orderArr(int [] array) {
        int[] orderArr = new int[array.length];
        orderArr[0] = ArrayOps.minValue(array);
        for (int i = 1; i < array.length ;i++ ) {
             int min = ArrayOps.secondMinValue(array);
             orderArr[i] = min;
        }

        return orderArr;
    }


    public static int [] unionSets(int [] array1, int[] array2) {
        int [] unionArr = new int [array1.length + array2.length];
        int j = 0;
        for (int i = 0; i < array1.length ;i++ ) {
            unionArr[i] = array1[i];
            j++;        
        }

        for (int l = 0; l < array2.length ;l++ ) {
             unionArr[j] = array2[l];
            j++;     
        }

        
        int [] finalArr = new int [j];
        for (int m = 0; m < j ;m++ ) {
            finalArr[m] = unionArr[m];
        }

        finalArr = buildSet(finalArr);
        finalArr = orderArr(finalArr);

        return finalArr;
    }

    public static int [] intersectionSets(int [] array1, int[] array2) {
        int [] intersectionArr = new int[array1.length + array2.length]; 
        int j = 0;
        for (int i = 0; i < array1.length ;i++ ) {
            if(contains(array2, array1[i]))
            {
                intersectionArr[i] = array1[i];
                j++;
            }
        }

        for (int k = 0; k < array2.length ;k++ ) {
            if(contains(array1, array2[k]))
            {
                intersectionArr[j] = array2[k];
                j++;
            }
        }

        
        int [] finalArr = new int[j];
        for (int m = 0; m < j ;m++ ) {
            finalArr[m] = intersectionArr[m];
        }

        finalArr = buildSet(finalArr);
        finalArr = orderArr(finalArr);
        return finalArr;
    }

    public static int [] trimArr(int [] array) {
        int i = 0; 
        while((array[i] != 0) || (i == 0)){
            i++;
        }

        int [] trimed = new int[i];
        for (int j = 0; j < i ;j++ ) {
            trimed[j] = array[j];
        }

        return trimed;
    }

    public static int [] diffSets(int [] array1, int[] array2) {
        int [] diffArr = new int[array1.length];
        int j = 0;
        for (int i = 0; i < array1.length ;i++ ) {
            if(!contains(array2, array1[i]))
            {
                diffArr[j] = array1[i];
                j++;       
            }
        }

        if(diffArr[diffArr.length - 1] == 0)
        {
            diffArr = trimArr(diffArr);
        }

        diffArr = buildSet(diffArr);
        diffArr = orderArr(diffArr);
        return diffArr;
    }

    public static int [] symDiffSets(int [] array1, int[] array2) {
        int [] diffArr1 = diffSets(array1, array2);
        int [] diffArr2 = diffSets(array2, array1);
        for (int i = 0; i < diffArr1.length ;i++ ) {
            System.out.print(diffArr1[i]+" ");
        }

        System.out.println(" ");
        for (int i = 0; i < diffArr2.length ;i++ ) {
            System.out.print(diffArr2[i]+" ");
        }

        System.out.println(" ");
        //int [] symDiffArr = unionSets(diffArr1, diffArr2);
        
        int [] symDiffArr = new int[diffArr1.length + diffArr2.length];
        int j = 0;
        for (int i = 0; i < diffArr1.length ;i++ ) {
            symDiffArr[i] = diffArr1[i];
            j++;
        }

        for (int i = 0; i < diffArr2.length ;i++ ) {
            symDiffArr[j] = diffArr2[i];
            j++;
        }

        return symDiffArr;
    }

}


