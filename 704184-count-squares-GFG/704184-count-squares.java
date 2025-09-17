// User function Template for Java

class Solution {
    static int countSquares(int n) {
        // code here
        int cnt = 0, i=1;
        while(i*i < n){
            cnt++;
            i++;
        }
        return cnt;
    }
}