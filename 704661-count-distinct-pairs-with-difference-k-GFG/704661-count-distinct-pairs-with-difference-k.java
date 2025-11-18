// User function Template for Java

class Solution {
    public int TotalPairs(int[] nums, int k) {
        // Code here
        int n = nums.length;
        
        if(n<=1) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int num : nums){
            set.add(num);
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        
        int cnt = 0;
        
        if(k == 0){
            for(int key : freq.keySet()){
                if(freq.get(key) > 1)
                    cnt++;
            }
        } else{
            for(int x : set){
                if(set.contains(x+k))
                    cnt++;
            }
        }
        
        return cnt;
    }
}