class Solution {
    public void rearrange(int arr[]) {
        // Approach 2 : Sortinng -- Encoding -- Two-pointer
        // Space: O(1), Time: O(n log n)
        // Step 1 : Sort the array
        Arrays.sort(arr);
        int n =  arr.length;
        
        // Step 2 : Take 2 pointers
        int minIndex = 0, maxIndex = n-1;
        int maxElement = arr[n-1]+1;
        
        // Step 3 : Traverse the array, do encoding and store answers
        for(int i = 0; i<n; i++){
            if(i%2 == 0){
                //Even index --> place maximum
                arr[i] += (arr[maxIndex] % maxElement) * maxElement;
                maxIndex--;
            } else{
                // Odd Index --> place minimum
                arr[i] += (arr[minIndex] % maxElement) * maxElement;
                minIndex++;
            }
        }
        
        // Step 4 : Decode the array to get the original re-arranged array
        for (int i = 0; i < n; i++){
            arr[i] = arr[i] / maxElement;
        }
    }
}
