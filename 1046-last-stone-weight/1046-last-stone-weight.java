class Solution {
    public int lastStoneWeight(int[] stones) {
        // Step 1 : Build Max Heap Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : stones) pq.offer(x);

        // Step 2 : Smash the stones in Max Heap, until 1 ele. remaining
        while(pq.size() > 1){
            int y = pq.poll(); //heaviest stone
            int x = pq.poll(); // 2nd heaviest stone

            if(x != y) pq.offer(y - x);   // Store new stone back    
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
