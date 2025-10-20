class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        //Brute-force: Find maxProduct of each possible sub-array of length : 1 to n
        int maxProduct = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            int product = 1;
            for(int j = i; j<n; j++){
                product *= nums[j];
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }
}