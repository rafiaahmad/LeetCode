class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        
        int low = 1; int high = x / 2;
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(mid <= x/mid){
                ans = mid; // possible answer
                low = mid + 1; // try bigger
            }
            else
                high = mid - 1; // try smaller
        }

        return ans;
    }
}