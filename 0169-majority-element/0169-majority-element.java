class Solution {
    public int majorityElement(int[] nums) {
        // HashMap<Integer, Integer> freq = new HashMap<>();
        // List<Integer> result = new ArrayList<>();
        // int res = 0;

        // //Step 1 : Count frequency of each element
        // for(int x : nums)
        //     freq.put(x, freq.getOrDefault(x, 0) + 1);
        
        // //Step 2 : Check freq > n/3 times
        // for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
        //     if(entry.getValue() > nums.length/2)
        //         // result.add(entry.getKey());
        //         res = entry.getKey();
        //         break;
        // }

        // return res;
        // List<Integer> result = new ArrayList<>();
        // if (nums == null || nums.length == 0) return result;
        
        // Step 1: Find potential candidates
        int candidate1 = 0, candidate2 = 1; // initialize with different numbers
        int count1 = 0, count2 = 0;
        
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
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