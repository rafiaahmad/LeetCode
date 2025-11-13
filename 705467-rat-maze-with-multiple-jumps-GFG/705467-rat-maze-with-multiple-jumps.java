class Solution {
    public int[][] ShortestDistance(int[][] matrix) {
        // Code here
        int n = matrix.length;
        int[][] path = new int[n][n];
        
        if(solveMaze(matrix, path, 0, 0, n))
            return path;
        
        return new int[][]{{-1}};
    }
    
    private boolean solveMaze(int[][] matrix, int[][] path, int i, int j, int n){
        //Base Case: Reached Destination
        if(i == n-1 && j == n-1){
            path[i][j] = 1;
            return true;
        }
        
        //Boundry + block check
        if(i >= n || j >= n || matrix[i][j] == 0) return false;
        
        //Mark current cell
        path[i][j] = 1;
        
        //explore all possible jumps
        for(int jump = 1; jump <= matrix[i][j]; jump++){
            //Move Right
            if(solveMaze(matrix, path, i, j+jump, n)) return true;
            
            //Move Down
            if(solveMaze(matrix, path, i+jump, j, n)) return true;
        }
        
        //BackTracking
        path[i][j] = 0;
        return false;
    }
}