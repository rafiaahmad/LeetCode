class Solution {
    int maxLength(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixSum = 0;
        int maxLen = 0;
        
        for(int i = 0; i < arr.length; i++){
            prefixSum += arr[i];
            
            if(prefixSum == 0)
                maxLen = i+1;
                
            if(map.containsKey(prefixSum)){
                int prevIndex = map.get(prefixSum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else
                map.put(prefixSum, i);
        }
        
        return maxLen;
    }
}