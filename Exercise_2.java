import java.util.Random;

class QuickSort { 
	// Time Complexity : O(n logn) Average Case
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : Changing the pivot from the first or last element
	// gave a better runtime, but the problem got a bit complex
	
    /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
    void swap(int arr[],int i,int j){
        //Your code here   
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
    
    // Selecting a random pivot for better runtime,
 	// instead of selecting the first or last element
 	int getPivot(int low, int high) {
 		Random rand = new Random();
 		return rand.nextInt((high - low) + 1) + low;
 	}
    
 	int partition(int arr[], int low, int high) { 
	 	 //Write code here for Partition and Swap 
		 swap(arr, low, getPivot(low, high));
		 int j = low + 1;
		 
		 for(int i=j; i<=high; i++) {
			 if(arr[i] < arr[low])
				 swap(arr, i, j++);
		 }
		 
		 swap(arr, low, j-1);
		 return j - 1;
	 }
    
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(int arr[], int low, int high) {  
    	// Recursively sort elements before partition and after partition
    	if(low < high) {
    		int p = partition(arr, low, high);
        	
        	sort(arr, low, p - 1);
        	sort(arr, p + 1, high);
    	}
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
    // Driver program 
    public static void main(String args[]) { 
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
  
        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        printArray(arr); 
    } 
} 
