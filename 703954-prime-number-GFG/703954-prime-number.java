class Solution {
    static boolean isPrime(int n) {
        // code here
        if(n==1) return false;
        if (n==2) return true;
        // for(int i=2; i<n; i++){
        //     if(n%i == 0)
        //         return false;
        // }
        int i=2;
        while(i*i <=n){
            if(n%i == 0)
                return false;
            i++;
        }
        return true;
    }
}