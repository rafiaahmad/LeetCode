class Solution {
    public int countPrimes(int n) {
    //     int cnt = 0;
    //     for(int i =2; i<n; i++){
    //         if(isPrime(i))
    //             cnt++;
    //     }
    //     return cnt;
    // }

    // static Boolean isPrime(int n){
    //     if(n<2) return false;
    //     if(n == 2 || n==3) return true;
    //     if(n%2 == 0) return false;

    //     for(int i=3; i*i<=n; i+=2){
    //         if(n%i == 0)
    //             return false;
    //     }
    //     return true;
    boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, true);

    // isPrime[0] = false;
    // isPrime[1] = false;

    for(int p = 2; p*p<n; p++){
        if(isPrime[p]){
            for(int multiple = p*p; multiple<n; multiple+=p){
                isPrime[multiple] = false;
            }
        }
    }

    int cnt = 0;
    if(n<=2) return cnt;
    for(int i=3; i<=n; i++){
        if(isPrime[i-1])
            cnt++;
    }
    return cnt;
    }
}