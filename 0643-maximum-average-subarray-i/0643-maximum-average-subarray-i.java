class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //Step 1 : Prepare average of the initial Window of size k
        double sum = 0;

        for(int i = 0; i<k; i++)
            sum += nums[i];
        
        double maxAvg = sum / k;

        //Slide the window
        for(int i = k; i<nums.length; i++){
            sum += nums[i] - nums[i-k];
            double currAvg = sum / k;
            maxAvg = Math.max(currAvg, maxAvg);
        }

        return maxAvg;
    }
}