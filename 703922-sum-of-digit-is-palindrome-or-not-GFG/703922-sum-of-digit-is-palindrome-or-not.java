// User function Template for Java

class Solution {
    boolean isDigitSumPalindrome(int n) {
        // calculate sum of digits
        int sum = 0;
        while(n>0){
            sum += (n%10);
            n /= 10;
        }
        
        //check if sum is palindrome
        //reverse the sum and check if rev == sum
        int num = sum;
        int rev = 0;
        while(num > 0){
            int tmp = num%10;
            rev = rev*10 + tmp;
            num /= 10;
        }
        
        return (sum == rev);
    }
}