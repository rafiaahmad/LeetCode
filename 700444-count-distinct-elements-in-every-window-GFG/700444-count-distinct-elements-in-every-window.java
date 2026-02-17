class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int distinct = 0;
        
        // Step 1 : First Window
        for(int i = 0; i < k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(map.get(arr[i]) == 1)
                distinct++;
            
        }
        res.add(distinct);
        
        // Step 2 : Slide Window
        for(int i = k; i < arr.length; i++){
            
            // Remove outgoing element
            int outgoing = arr[i - k];
            map.put(outgoing, map.get(outgoing) - 1);
            if(map.get(outgoing) == 0){
                map.remove(outgoing);
                distinct--;
            }
                
            // Add incoming element
            int incoming = arr[i];
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);
            if(map.get(incoming) == 1)
                distinct++;
            
            res.add(distinct);
        }
        
        return res;
    }
}