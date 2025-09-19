// User function Template for Java

class Solution {
    static int largestPrimeFactor(int n) {
        // code here
        int maxPrime = -1;
        
        //remove all even factors
        while(n%2 == 0){
            maxPrime = 2;
            n /=2;
        }
        
        //check odd factors
        for(int i = 3; i*i<=n; i +=2){
            while(n%i == 0){
                maxPrime = i;
                n /=i;
            }
        }
        
        //check even if n>2, then n itself is Prime
        if(n>2){
            maxPrime = n;
        }
        
        return maxPrime;
    }
}