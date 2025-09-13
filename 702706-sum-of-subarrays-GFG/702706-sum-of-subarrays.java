class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int n = arr.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int freq = (i + 1) * (n - i); // how many subarrays include arr[i]
            total += arr[i] * freq;
        }
        return total;
    }
}
