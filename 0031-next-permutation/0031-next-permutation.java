class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find break point
        int  i = n-2; 

        //traverse array from last compare adjacent until decrement start
        while(i >=0 && nums[i] >= nums[i+1]){
                i--;
            }
        //i return the breakpoint index

        //Step 2: Find ele. just > ele. of breakpoint index
        if(i>=0){
            int j = n-1;
            while(nums[j] <= nums[i] )
                j--;
            //Step 3: Swap ele. of index start with minIndex
            swapElement(nums, i, j);
        }

        //Step4: Reverse the ele. of array after breakpoint index after swap
        reverseArray(nums, i+1, n-1);

        //Here we have the array having next permutation
    }

    public void swapElement(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public void reverseArray(int[] nums, int start, int end){
        

        while(start<end){
            swapElement(nums, start, end);
            start++;
            end--;
        }
    }
}