// User function Template for Java

class Solution {
    static int evenlyDivides(int n) {
        // code here
        int cnt = 0, ori_n = n;
        while(n>0){
            int d = n%10;
            if( d !=0 && ori_n%d == 0){ 
                cnt++;
            }
            n = n/10;
        }
        return cnt;
    }
}