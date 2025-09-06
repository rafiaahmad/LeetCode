class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int min = matrix[0][0], max = matrix[n-1][n-1];
        
        while(min < max){
            int mid = min + (max-min)/2;
            int count = BSCountLess(matrix, mid, n);

            if(count >= k){
                max = mid;
            } else{
                min = mid+1;
            }
        }
        return min;
    }

    int BSCountLess(int[][] matrix, int target, int n){
        int count = 0;
        int row = n-1; //Start frm botton left
        int col = 0;  

        while(row >=0 && col < n){
            if(matrix[row][col] <= target){
                //all element in current column upto this row are <=target
                count += row + 1;
                col++;
            } else{
                row--; // all element in this row will be greater than target
            }
        }
        return count;
    }
}
