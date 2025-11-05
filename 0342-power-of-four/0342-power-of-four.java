class Solution {
    public boolean isPowerOfFour(int n) {
        //Base case
        if(n <= 0) return false;
        if(n == 1) return true;

        //if not divisible by 4, return false
        if(n%4 != 0) return false;

        //Call recursive function
        return isPowerOfFour(n/4);
    }
}