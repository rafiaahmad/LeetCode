class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int x : nums) maxHeap.offer(x);

        int a = maxHeap.poll();
        int b = maxHeap.poll();

        return (a - 1) * (b - 1);
    }
}