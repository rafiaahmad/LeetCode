class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1; // two pointers for deciding the 2 lines
        int maxArea = Integer.MIN_VALUE;

        while(left<right){
            int width = right-left; // width
            int high = Math.min(height[right], height[left]); //height
            maxArea = Math.max(maxArea, width * high); // maxArea keep on calculating

            // logic to shrink
            if(height[left] < height[right]) 
                left++;
            else
                right--;
        }

        return maxArea;
    }
}