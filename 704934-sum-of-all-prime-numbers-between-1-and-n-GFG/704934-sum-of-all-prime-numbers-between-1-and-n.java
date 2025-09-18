class Solution {
    public int prime_Sum(int n) {
        // code here
        int sumPrime = 0;
        for(int i=2; i<=n; i++){
            //check whether number is prime
            if(checkPrime(i)){
                sumPrime +=i;
            }
        }
        return sumPrime;
    }
    
    static boolean checkPrime(int n){
        if(n <= 1) return false;
        else if(n==2) return true;
        if(n%2 == 0) return false;
        for(int i=3; i*i<=n; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}