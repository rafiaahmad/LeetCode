class Solution {
    public void rearrange(int arr[]) {
        // Approach 1 : Naive Approach: Reversing subarrays repeatedly
        // Space: O(1), Time: O(n^2) -- 
        
        int n =  arr.length;
        
        // Step 1 : Sort the array
        Arrays.sort(arr);
        
        
        // Step 2: Alternate placement of max and min
        // We'll reverse subarrays to bring max to the correct position
        for(int i = 0; i<n; i++){
            // if(i%2 == 0){
                //Even index --> place maximum
                reverse(arr, i, n-1);
            // }
            // Odd Index --> place minimum by-default
        }
    }
    
    public void reverse(int[] arr, int start, int end){
        while(start < end){
            //use two pinter and tmp variable for swapping
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            
            start++;
            end--;
        }
    }
}
