class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];

        int maxArea = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                // Step 1 : Build histogram for current row
                if(matrix[i][j] == '1')
                    heights[j] += 1;
                else
                    heights[j] = 0;
            }

            // Step 2 : Calculate largest rectanlge area for this histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights){
        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i <= n; i++){
            int curr = (i == n ? 0 : heights[i]);

            while(!st.isEmpty() && curr < heights[st.peek()]){
                int height = heights[st.pop()];
                // int right = i, left = st.isEmpty() ? -1 : st.peek();
                // int width = right - left - 1;
                int  width = st.isEmpty() ? i : i - st.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
    }
}