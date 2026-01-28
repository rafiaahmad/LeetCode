class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int l = 0, r = mat.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            int maxRowM = Arrays.stream(mat[m]).max().getAsInt();
            int maxRowNext = Arrays.stream(mat[m+1]).max().getAsInt();

            if (maxRowM >= maxRowNext) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        int row = l;
        int col = 0;
        for (int j = 1; j < mat[row].length; j++) {
            if (mat[row][j] > mat[row][col]) {
                col = j;
            }
        }
        return new int[]{row, col};
    }
}