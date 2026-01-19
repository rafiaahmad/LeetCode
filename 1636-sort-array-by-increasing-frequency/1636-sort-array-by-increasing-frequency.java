class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1 : Frequency Counting
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        // Step 2 : Create List of entries
        List<Map.Entry<Integer, Integer>> list  = new ArrayList<>(freqMap.entrySet());

        // Step 3 : Sort using comparator
        list.sort((a,b) -> {
            if(a.getValue() != b.getValue())
                return a.getValue() - b.getValue();
            else
                return b.getKey() - a.getKey();

        });

        // Step 4 : Build the sorted array
        int[] res = new int[nums.length];
        int k = 0;
        for(int i = 0; i<list.size(); i++){
            int freq = list.get(i).getValue();
            for(int j = 0; j<freq; j++)
                res[k++] = list.get(i).getKey();
        }

        return res;
    }
}