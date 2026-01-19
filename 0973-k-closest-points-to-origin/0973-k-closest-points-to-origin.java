class Solution {
    static class Pair{
        int dist;
        int[] point;

        Pair(int dist, int[] point){
            this.dist = dist;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        // Step 1 : Build Max Heap
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.dist - a.dist);

        for(int[] p : points){
            int dist = p[0]*p[0] + p[1]*p[1];
            maxHeap.offer(new Pair(dist, p));

            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        // Step 2 : Build K closest point to Origin
        int[][] res = new int[k][2];
        int idx = 0;

        while(!maxHeap.isEmpty())
            res[idx++] = maxHeap.poll().point;

        return res;
    }
}