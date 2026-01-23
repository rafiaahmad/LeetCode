class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];   // compare strength
                return a[1] - b[1];                     // compare index
            }
        );

        // Step 1: Compute strength of each row
        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int val : mat[i]) {
                if (val == 1) soldiers++;
                else break;
            }
            minHeap.offer(new int[]{soldiers, i});
        }

        // Step 2: Extract k weakest rows
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[1];
        }

        return res;
    }
}