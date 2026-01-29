class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int x : nums){
            if(x % 2 == 0)
                freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
            
        int maxFreq = 0;
        int ans = -1;
        
        for(int key : freq.keySet()){
            int frequency = freq.get(key);

            if(frequency > maxFreq || (maxFreq == frequency && key < ans)){
                ans = key;
                maxFreq = frequency;
            }
        }

        return ans;
    }
}