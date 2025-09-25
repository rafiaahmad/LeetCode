class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        //sort the stalls
        Arrays.sort(stalls);
        int res = 0; //minimum distance assume zero initially
        
        //Apply Binary search
        int low = 1, high = stalls[stalls.length-1]-stalls[0];
        while(low<=high){
            
            int mid = low + (high-low)/2;
            //if mid distance is possible for all cows to allocate
            //then search for larger distance
            if(check(stalls, k, mid)){
                res = mid;
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        
        return res;
    }
    
    //function to check if we can place k cows with atleast dist aprart or not
    static boolean check(int[] stalls, int k, int dist){
        int cnt = 1,
            prev = stalls[0];
        
        for(int i = 1; i<stalls.length; i++){
            if(stalls[i]-prev >= dist){
                prev = stalls[i];
                cnt++;
            }
            
            //check if count equals k return true -- Early exit
            if( cnt == k) return true;
        }
        
        return false; //otherwise return false in last
    }
}