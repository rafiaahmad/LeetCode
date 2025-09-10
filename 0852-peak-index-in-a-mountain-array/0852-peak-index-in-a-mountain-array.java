class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length-1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
            // Peak lies on the right side (strictly increasing part)
                start = mid + 1;
            } else {
            // Peak lies on the left side (including mid)
                end = mid;
            }
        }
        // When start == end, both point to the peak element
        return start;  // this gives index of peak
    }
}