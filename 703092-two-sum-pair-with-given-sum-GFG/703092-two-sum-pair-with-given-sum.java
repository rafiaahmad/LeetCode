class Solution {
    boolean twoSum(int arr[], int target) {
        
        //Approach 1 : TC: O(n^2), SC: O(1)
        int n = arr.length;
        if(n==1) return false;
        
        Arrays.sort(arr);
        
        int left = 0, right = n-1;
        while(left<right){
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