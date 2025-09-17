class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        // Using recursive approach
        int gcd = findGCD(a,b);
        int lcm = (a*b)/gcd;
        
        return new int[]{lcm, gcd};
    }
    
    static int findGCD(int a, int b){
        if(b==0) return a;
        return findGCD(b, a%b);
    }
}