class Solution {
    public int smallestEvenMultiple(int n) {
        if(n==1) return 2;
        int ans = 0;
        if(n>1){
            if(n%2 == 0)
                ans = n;
            else
                ans = n*2;
        }
        return ans;
    }
}