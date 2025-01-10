package Activities;

public class Main {
    public static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;

        int i = 0, l = 0, r = 0;

        // SORT AND MERGING THE LEFT AND RIGHT ARRAY
        while (l < leftSize && r < rightSize) {
            if(leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        // FINAL SORT AND MERGE
        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public static void mergeSort(int[] array) {
        int length = array.length;

        /* IF ELEMENTS BELOW OR EQUAL 1, IT RETURN */
        if(length <= 1) return;

        int middle = length / 2; // DIVIDE THE ARRAY

        /* CREATE NEW SUB-ARRAY */
        int[] leftArray = new int[middle]; // SUB-ARRAY LEFT
        int[] rightArray = new int[length - middle]; // SUB-ARRAY RIGHT     
        
        int i = 0; // LEFT ARRAY
        int j = 0; // RIGHT ARRAY
        
        // DIVIDING THAT WHICH ELEMENT WILL BE ON LEFT OR RIGHT
        for(; i < length; i++) {
            if(i < middle) { // LEFT ARRAY
                leftArray[i] = array[i];
            }
            else { // RIGHT ARRAY
                rightArray[j] = array[i];
                j++;
            }
        }

        // DIVIDE THE LEFT ARRAY UNTIL ONLY ONE ELEMENT REMAINS
        mergeSort(leftArray);
        // DIVIDE THE RIGHT ARRAY UNTIL ONLY ONE ELEMENT REMAINS
        mergeSort(rightArray);
        // MERGE IN FIX ORDERS
        merge(leftArray, rightArray, array);
    }
    
    public static void main(String[] args) {
        int[] array = {3, 2, 1};

        mergeSort(array);

        for(int i : array) {
            System.out.print(i + " ");
        }
    }
}
