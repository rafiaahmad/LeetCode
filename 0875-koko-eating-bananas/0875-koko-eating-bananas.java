class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = 0;
        
        for(int pile : piles) {
            right = Math.max(right, pile);
        }
        
        int answer = right;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(canFinish(piles, h, mid)) {
                answer = mid;
                right = mid - 1;  // try smaller speed
            } else {
                left = mid + 1;   // need larger speed
            }
        }
        
        return answer;
    }
    
    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        
        for(int pile : piles) {
            hours += (pile + k - 1) / k;  // ceil division
        }
        
        return hours <= h;
    }
}