/**
 * @author
 */
public class IceCreams {
    /**
     * find the maximum ice cream bars you can buy
     * @param costs array of costs of all ice cream bars, unsorted
     * @param dollars the total amount of dollars you can use to buy the ice cream 
     * return how many ice cream can buy with the money
     */
	
	public static int maxIceCreams(int[] costs, int dollars) {
        int sum = 0;
        int counter = 0;
        int length = costs.length;
        
        mergeSort(costs, length);
        
        /* Test code to see if array is sorted properly
        for(int x = 0; x < length; x++) {
        	System.out.println(costs[x]);
        }
        */
        
        while (sum <= dollars) {
        	for(int i = length - 1; i >= 0; i--) {
        		counter++;
        		sum += costs[i];
        	}
        }
        return counter;
    }
	
	//mergeSort and merge functions to sort ice cream prices
	public static void mergeSort(int[] a, int n) {
		if(n < 2) {
			return;
		}
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		for(int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		for(int i = mid; i < n; i++) {
			right[i - mid] = a[i];
		}
		mergeSort(left, mid);
		mergeSort(right,n - mid);
		
		merge(a, left, right, mid, n - mid);
	}
	
	public static void merge(int[] a, int[] left, int[] right, int l, int r) {
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < l && j < r) {
			if(left[i] <= right[j]) {
				a[k++] = right[j++];
			} else {
				a[k++] = left[i++];
			}
		}
		
		while(i < l) {
			a[k++] = left[i++];
		}
		while(j < r) {
			a[k++] = right[j++];
		}
	}
	

    public static void main(String[] args) {
        int[] costs = {5, 1, 6, 2, 3, 4};
        int dollars = 6;
        int total;
        
        total = maxIceCreams(costs, dollars);
        
        System.out.println(total);
        
    }
}