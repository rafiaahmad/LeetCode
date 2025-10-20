class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        //Step 1 : Count frequency of each element
        for(int x : nums)
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        
        //Step 2 : Check freq > n/3 times
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() > nums.length/3)
                result.add(entry.getKey());
        }

        return result;
    }
}