class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        if(n==2) return ((nums[0]>nums[1])? 0 : 1);
        int start = 0;
        for(int i=1; i<n-1; i++){
            if( (nums[i] > nums[i-1]) && (nums[i] > nums[i+1])){
                start = i;
            } else if(i==n-2 && (nums[n-1] > nums[n-2])) start = n-1;
        }
        return start;
    }
}