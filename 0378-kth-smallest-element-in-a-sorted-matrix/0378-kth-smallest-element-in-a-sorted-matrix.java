*
This is LeetCode 378 – Kth Smallest Element in a Sorted Matrix.

Since both rows and columns are sorted, there are two optimal approaches:

\U0001f539 Approach 1: Binary Search on Values

The smallest element is matrix[0][0], largest is matrix[n-1][n-1].

Perform binary search on the value range [min, max].

For a candidate mid, count how many elements are ≤ mid:

Start from bottom-left (or top-right) and traverse efficiently in O(n).

If count < k → need bigger values.

If count >= k → mid might be the answer, search left.

Repeat until low > high. The answer is the smallest mid with count ≥ k.*/
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
