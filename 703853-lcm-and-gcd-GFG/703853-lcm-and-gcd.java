class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int ori_a = a, ori_b = b;
        //Find GCD sing Euclidean Algo
        // 
        while(b>0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        int gcd = a;
        
        //calculate lcm = (a*b)/ gcd;
        int lcm = (ori_a*ori_b)/gcd;
        
        return new int[]{lcm, gcd};
    }
}