class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        HashSet<Integer> set  = new HashSet<>();
        
        int prefixSum = 0;
        
        for(int i = 0; i<arr.length; i++){
            prefixSum += arr[i];
            
            if(prefixSum == 0 || set.contains(prefixSum))
                return true;
                
            set.add(prefixSum);
        }
        
        return false;
    }
}