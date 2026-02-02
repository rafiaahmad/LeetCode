class Solution {
    public int majorityElement(int[] nums) {        
        // Step 1: Find potential candidates
        int candidate1 = 0, candidate2 = 1; // initialize with different numbers
        int count1 = 0, count2 = 0;
        
        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
            else if (count1 == 0){
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify actual counts
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }
        
        if (count1 > nums.length / 2) 
            // result.add(candidate1);
            return candidate1;
        return candidate2;
        // if (count2 > nums.length / 3) result.add(candidate2);
        
        // return result;
    }
}