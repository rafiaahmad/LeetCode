class Solution {
    public boolean isPowerOfTwo(int n) {
        // T.C: O(log n) S.c : O(1)
        if (n<= 0) return false;
        if (n==1) return true;
        while(n > 0){
            if(n == 1) return true;
            if (n%2 == 1) return false;
            n = n/2;
        }
        return true;
    }
}