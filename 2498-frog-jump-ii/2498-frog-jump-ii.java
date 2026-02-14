class Solution {
    public int maxJump(int[] stones) {
        
        int maxJump = 0;
        
        for(int i = 0; i < stones.length - 2; i++){
            maxJump = Math.max(maxJump, stones[i+2] - stones[i]);
        }
        
        return maxJump;
    }
}