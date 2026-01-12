class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int ans = Integer.MIN_VALUE;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while(low<=high){
            int mid = low + (high-low)/2;

            if(countLessOrEqual(matrix, mid, n, k)){
                ans = mid;
                high = mid-1; // search for next smaller mid possible
            } else{
                low = mid+1; // search for higher mid which is possible smallest
            }
        }

        return ans;
    }   

    // Function to check whether mid is the possible Kth smallest
    public boolean countLessOrEqual(int[][] matrix, int target, int n, int k){
        int count = 0;
        int row = 0; int col = n-1;

        while(row < n && col>=0){
            if(matrix[row][col] > target){
                //all ele. in this column are > target
                col--;
            } else if(matrix[row][col] <= target){
                //all element in row are <= target
                count += col + 1; //count them
                row++; //proceed to next row
            }
        }

        return (count>=k); // return true if count>= k
    }
}