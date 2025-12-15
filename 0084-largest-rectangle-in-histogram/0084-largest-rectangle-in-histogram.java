class Solution {
    public int largestRectangleArea(int[] heights) {
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