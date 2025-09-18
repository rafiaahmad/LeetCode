class Solution {
    public int countPrimes(int n) {
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // if(n>=0) isPrime[0] = false;
        // if(n>=1) isPrime[1] = false;

        for(int p=2; p*p<n; p++){
            if(isPrime[p]){
                for(int multiple=p*p; multiple<n; multiple += p){
                    isPrime[multiple] = false;
                }
            }
        }

        int count = 0;
        if(n<=2) return count;
        for(int p=3; p<=n; p++){
            if(isPrime[p-1])
                count++;
        }
        return count;
    }
}