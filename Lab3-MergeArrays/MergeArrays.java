import java.util.Arrays;

public class MergeArrays {
    /**
     * Function that takes in two arrays arr1,arr2, and two integer m,n
     * merge m elements from arr1 and n elements from arr2 into arr1
     * 
     * @param arr1 1st array of elements, has size of m+n
     * @param m m elements to be merged,
     * @param arr2 2nd array of elements, has size of n
     * @param n n elements to be merged
     */
    public void merge(int[] arr1, int m, int[] arr2, int n) {
     
    	while (m > 0 && n > 0) {
    		
    		if(arr1[m - 1] > arr2[n - 1]) {
    			arr1[m + n - 1] = arr1[m - 1];
    			m--;
    			
    		} else {
    			
    			arr1[m + n - 1] = arr2[n - 1];
    			n--;
    		}
    	}
    	
    	while(n > 0) {
    		arr1[m + n - 1] = arr2[n - 1];
    		n--;
    	}
    }

    public static void main(String[] args) {
        //Modify the main as needed to test
        MergeArrays ma = new MergeArrays();
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,7};
        int m = 3, n = 3;
        ma.merge(arr1, m, arr2, n);
        System.out.println("Expected: [1, 2, 2, 3, 5, 7]"); 
        System.out.println("Actual:   "+Arrays.toString(arr1));
        
    }
}