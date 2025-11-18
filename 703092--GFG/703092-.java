class Solution {
    boolean twoSum(int arr[], int target) {
        
        //Approach 1 : TC: O(n^2), SC: O(1)
        int n = arr.length;
        if(n==1) return false;
        
        int left = 0, right = n-1;
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(arr[i] + arr[j] == target && i != j)
                    return true;
            }
        }
        
        return false;
    }
}