class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int maxArea = Integer.MIN_VALUE;

        while(left<right){
            int width = right-left;
            int high = Math.min(height[right], height[left]);
            maxArea = Math.max(maxArea, width * high);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}