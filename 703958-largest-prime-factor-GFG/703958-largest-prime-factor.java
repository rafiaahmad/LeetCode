// User function Template for Java

class Solution {
    static int largestPrimeFactor(int n) {
        // code here
        int sqrt = (int) Math.sqrt(n);
        if(isPrime(n)) return n;
        
        int greatPrime = 2;
        for(int i = 2; i<=sqrt; i++){
            if(n%i == 0)
            {
                if(isPrime(i))
                   greatPrime = Math.max(greatPrime, i) ;
            }
        }
        
        for(int j = sqrt; j>0; j--){
            if(n%j == 0)
            {
                if(isPrime(n/j))
                   greatPrime = Math.max(greatPrime, n/j) ;
            }
        }
        
        return greatPrime;
    }
    
    static boolean isPrime(int n){
        if(n<2) return false;
        if(n==2) return true;
        if(n%2 == 0) return false;
        int i=3;
        
        while(i*i <=n){
            if(n%i == 0)
                return false;
            i += 2;
        }
        return true;
    }
}