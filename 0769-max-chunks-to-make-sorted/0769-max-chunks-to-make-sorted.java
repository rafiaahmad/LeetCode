class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunks = 0;

        for (int i = 0; i < n; i++) {
            int maxVal = arr[0];
            boolean isChunk = true;

            for (int j = 0; j <= i; j++) {
                maxVal = Math.max(maxVal, arr[j]);
            }

            if (maxVal == i) {
                chunks++;
            }
        }

        return chunks;
    }
}