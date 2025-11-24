class Solution {
    public int lastStoneWeight(int[] stones) {
        // Create a max‐heap (priority queue with reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : stones) {
            maxHeap.offer(w);
        }

        // While there are at least two stones
        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();     // heaviest
            int y = maxHeap.poll();     // second heaviest

            if (x != y) {
                maxHeap.offer(x - y);
            }
            // else if x == y → both removed, no push back
        }

        // If one stone remains, return it; otherwise 0
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
