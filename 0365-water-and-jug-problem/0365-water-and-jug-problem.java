class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        // Step 1: Capacity check
        if (target > x + y) return false;

        // Step 2: GCD check
        return target % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}