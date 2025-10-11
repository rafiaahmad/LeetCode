class Solution {
    int missingNum(int arr[]) {
        int n = arr.length; 
        long sumN = ((long)(n + 1) * (n + 2)) / 2L; // cast to long BEFORE multiplication
        long total = 0L;
        for (int x : arr) total += x;
        return (int)(sumN - total);
    }
}
