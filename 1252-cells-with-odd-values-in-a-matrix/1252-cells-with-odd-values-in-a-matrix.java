class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];

        //count increment for rows and columns
        for(int[] ind : indices){
            row[ind[0]]++;
            col[ind[1]]++;
        }

         // Count odd rows and odd cols
        int oddRows = 0, oddCols = 0;
        for (int r : row) {
            if (r % 2 != 0) oddRows++;
        }
        for (int c : col) {
            if (c % 2 != 0) oddCols++;
        }
        
        // Formula
        return oddRows * (n - oddCols) + (m - oddRows) * oddCols;
    }
}