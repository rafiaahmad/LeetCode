class Solution {
    public int findKthLargest(int[] nums, int k) {
        //get minimum and maximum element of the array
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();

        int ans = Integer.MAX_VALUE;

        //Search space for binary search
        while(low<=high){
            int mid = low + (high-low)/2;

            if(countGreaterOrEqual(nums, k, mid)){
                ans = mid; // mid could be the possible answer
                //Search for higher mid which will satisfy this condn.
                low = mid + 1;
            } else{
                // search for lesser mid value
                high = mid - 1;
            }
        }
        return ans;
    }

    public static boolean countGreaterOrEqual(int[] nums, int k, int mid){
        int count = 0;

        for(int num : nums){
            if(num >= mid)
                count++;
        }
        return (count>=k);
    }
}