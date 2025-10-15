class Solution {
    public int subarraySum(int[] arr) {
        
        //Approach 3 : Mathematical formaula
        int sum = 0; 
        int n = arr.length;
        for(int i = 0; i<n; i++){
            // (n-1)*(i+1) times arr[i] appears in all possible subarrays
            sum += (n-i)*(i+1)*arr[i];
        }
        
        return sum;
    }
}
