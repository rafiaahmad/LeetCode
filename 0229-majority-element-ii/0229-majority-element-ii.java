class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Step 1 : find the cadidates
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for(int num : nums){
            if(candidate1 != 0 && num == candidate1)
                count1++;
            else if(candidate2 != 0 && num == candidate2)
                count2++;
            else if(count1 == 0){
                candidate1 = num;
                count1++;
            } else if(count2 == 0){
                candidate2 = num;
                count2++;
            } else{
                count1--;
                count2--;
            }
        }

        //Step 2 : count the freq. of candidates
        count1 = 0; count2 = 0;
        for(int num : nums){
            if(num == candidate1)
                count1++;
            else if(num == candidate2)
                count2++;
        }

        // Step 3 : Compare the count and add into result list
        List<Integer> result = new ArrayList<>();
        if(count1 > nums.length/3) result.add(candidate1);
        if(count2 > nums.length/3) result.add(candidate2);

        return result;
    }
}