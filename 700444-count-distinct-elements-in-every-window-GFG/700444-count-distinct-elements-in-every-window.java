class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] freq = new int[100001];
        int distinct = 0;
        
        // Step 1 : First Window
        for(int i = 0; i < k; i++){
            if(freq[arr[i]] == 0)
                distinct++;
                
            freq[arr[i]]++;
        }
        
        res.add(distinct);
        
        // Step 2 : Slide Window
        for(int i = k; i < arr.length; i++){
            // Remove outgoing elements
            int outgoing = arr[i - k];
            freq[outgoing]--;
            if(freq[outgoing] == 0)
                distinct--;
                
            // Add Incoming element
            int incoming = arr[i];
            if(freq[incoming] == 0)
                distinct++;
            freq[incoming]++;
            
            res.add(distinct);
        }
        
        return res;
    }
}