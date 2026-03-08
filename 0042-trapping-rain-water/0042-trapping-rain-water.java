class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int water = 0;

        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && height[i] > height[st.peek()]) {

                int mid = st.pop();

                if (st.isEmpty()) break;

                int left = st.peek();

                int width = i - left - 1;

                int boundedHeight =
                        Math.min(height[left], height[i]) - height[mid];

                water += width * boundedHeight;
            }

            st.push(i);
        }

        return water;
    }
}