class Solution {
    public void sortInWave(int arr[]) {
        // Approach3: O(N) solution - Optimal without sorting
        int n = arr.length;
        
        for(int i=0; i<n; i +=2){
            // If current even index is not the first element
            // and previous element is greater than current
            if(i>0 && arr[i-1] > arr[i]) 
                swap(arr, i-1, i);
                
            // If current even index is not the last element
            // and next element is greater than current
            if(i<n-1 && arr[i] < arr[i+1])
                swap(arr, i, i+1);
        }
    }
    
    public void swap(int[] arr, int i, int j){
        int temp    = arr[i];
            arr[i]  = arr[j];
            arr[j]  = temp;
    }
}
