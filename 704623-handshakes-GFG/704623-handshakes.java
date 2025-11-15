// User function Template for Java

class Solution {
    // Using Catalan no
    static int count(int N) {
        int n = N/2;
        
        return catalan(n);
    }
    
    static int catalan(int n){
        long res = 1;
        
        // formula: Cn = (2n)! / ((n+1)! * n!)
        // rewritten in product form to avoid huge factorials
        for(int i = 0; i<n; i++)
            res = res * (2L * (2*i+1)) / (i+2);
            
        return (int) res;
    }
}