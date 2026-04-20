class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 1; i < n - 1; i++) {
            // check peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i, right = i;

                // expand left
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                // expand right
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}