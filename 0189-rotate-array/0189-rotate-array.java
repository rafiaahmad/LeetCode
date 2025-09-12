class Solution {
    public void rotate(int[] nums, int k) {
        //Aprroach2: usin reverse In-place method k swap needed
        int n = nums.length;
         if (n > 1) {   // ✅ only do work if more than 1 element
            k = k % n;  // normalize k

            if (k > 0) {   // ✅ only rotate if needed
                //Step1: Reverse the entire Array
                reverse(nums, 0, n-1);

                //Step2: Reverse first k elements
                reverse(nums, 0, k-1);

                //Step3: Reverse last n=k elements
                reverse(nums, k, n-1);
            }
        }
    }

    static  void reverse(int[] nums, int left, int right){
        while(left<right){
            int temp    = nums[left];
            nums[left]  = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}