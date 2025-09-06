class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int min = matrix[0][0], max = matrix[n-1][n-1];
        
        while(min < max){
            int mid = min + (max-min)/2;

            int count = 0;
            for(int i = 0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(matrix[i][j] <= mid) count++;
                }
            }

            if(count >= k){
                max = mid;
            } else{
                min = mid+1;
            }
        }
        return min;
    }
}