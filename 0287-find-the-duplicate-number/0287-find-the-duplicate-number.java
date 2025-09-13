class Solution {
    public int findDuplicate(int[] nums) {
        // Approach1: Binary Search
        int low = 1, high = nums.length - 1;
        int duplicate = -1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            // count numbers <= mid
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            
            if (count > mid) {
                duplicate = mid;
                high = mid - 1; // search left half
            } else {
                low = mid + 1; // search right half
            }
        }
        return duplicate;
    }
}