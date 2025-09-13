class Solution {
    public int findDuplicate(int[] nums) {
        // Approach2: Floyd Detection Algorith (Slow and fast pointer)
        // Step 1: Find intersection
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Step 2: Find cycle entrance
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow; // or fast
    }
}