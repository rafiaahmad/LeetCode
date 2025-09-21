class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];

        //count increment for rows and columns
        for(int[] ind : indices){
            row[ind[0]]++;
            col[ind[1]]++;
        }

        int oddCount = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if ((row[i] + col[j]) % 2 != 0) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }
}