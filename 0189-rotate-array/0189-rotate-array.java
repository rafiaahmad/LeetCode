class Solution {
    public void rotate(int[] nums, int k) {
        //Aprroach1: Store result in new array
        int n = nums.length;
         if (n > 1) {   // ✅ only do work if more than 1 element
            k = k % n;  // normalize k

            if (k > 0) {   // ✅ only rotate if needed
                int[] res = new int[n];
        //add last k elements in first k-1 position of res array
        for(int i=0; i<k; i++) res[i] = nums[n-k+i];

        //add first n-k elements of nums to k to last index of res array
        for(int i=k; i<n; i++) res[i] = nums[i-k];

        //copy elements into original array
        for(int i=0; i<nums.length; i++) nums[i] = res[i];
            }
        }
    }
}