class Solution {
    public int subtractProductAndSum(int n) {
        int difference = 0, product = 1, sum = 0;
        while(n>0){
            int tmp = n%10;
            sum += tmp;
            product *= tmp;
            n /= 10;
        }

        return (product - sum);
    }
}