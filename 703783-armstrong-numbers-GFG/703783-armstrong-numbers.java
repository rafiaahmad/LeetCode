// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int ori_n = n;
        int sum = 0;
        while(n>0){
            int tmp = n%10;
            sum += (int) Math.pow(tmp, 3);
            n /= 10;
        }
        
        return (ori_n == sum);
    }
}