class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        int n = nums.length;

        for(int i = 0; i<n; i++){
            maxHeap.offer(nums[i]);

            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        return maxHeap.peek();
    }
}