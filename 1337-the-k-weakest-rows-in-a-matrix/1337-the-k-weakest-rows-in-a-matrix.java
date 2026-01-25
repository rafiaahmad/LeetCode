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
            // for (int val : mat[i]) {
            //     if (val == 1) soldiers++;
            //     else break;
            // }

            // Step 1.1 : Implement binary serach
            int left = 0; // first column
            int right = mat[i].length - 1; // last column
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(mat[i][mid] == 1){
                    soldiers = mid;
                    left = mid + 1 ;
                } 
                else
                    right = mid - 1;
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