class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums); // sort the array

        int low = 0, high = nums[nums.length-1] - nums[0];

        while(low<high){
            int mid = low + (high-low)/2;

            //count how many pairs <=mid
            int count = 0, j=0;
            for(int i = 0; i<nums.length; i++){
                while(j<nums.length && nums[j]-nums[i] <=mid){
                    j++;
                }
                count += (j-i-1);
            }

            if(count >=k){ // mid is big enough
                high = mid;
            } else{
                low = mid+1; // need bigger distance
            }
        }
        return low;
    }
}