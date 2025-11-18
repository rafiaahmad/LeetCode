class Solution {
    boolean twoSum(int arr[], int target) {
        
        //Approach 1 : TC: O(n + n log n), SC: O(1)
        int n = arr.length;
        if(n==1) return false;
        
        Arrays.sort(arr); // O(n log n)
        
        int left = 0, right = n-1;
        while(left<right){ // O(n)
            int sum = arr[left] + arr[right];
            
            if(sum == target)
                return true;
            else if(sum < target)
                left++;
            else
                right--;
        }
        
        return false;
    }
}