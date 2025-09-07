class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // sorting the array to ensure stalls in sequence
        Arrays.sort(stalls);
        int res = 0;
        
         // Search Space for Binary Search
         int low = 1;
         int high = stalls[stalls.length -1] - stalls[0];
         
         while(low <= high){
             int mid = low + (high-low)/2;
             
            // If the mid distance is possible, update
            // the result and search for larger distance
             if(check(stalls, k, mid)){
                 res = mid;
                 low = mid+1;
             } else{
                 high = mid-1;
             }
         }
         return res;
    }
    
    // function to check if we can place k cows
    // with at least dist distance apart
    static boolean check (int[] stalls, int k, int dist){
        int cnt = 1; //place 1st count at 0th index stalls[0]
        int prev = stalls[0];
        
        
        for(int i=1; i<stalls.length; i++){
            // if the current stall is at least dist away
            // from the previous one place the cow here
            if(stalls[i] - prev >= dist){
            prev = stalls[i];
            cnt++;
            
            if(cnt == k) return true;
            }
        }
        // return true if we are able to place all 'k' cows
        return false;
    }
}