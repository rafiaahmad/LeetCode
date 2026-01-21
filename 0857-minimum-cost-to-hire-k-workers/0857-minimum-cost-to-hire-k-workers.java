class Solution {
    static class Worker{
        double ratio;
        int quality;

        Worker(double ratio, int quality){
            this.ratio = ratio;
            this.quality = quality;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // Step 1 : Create workers
        List<Worker> workers = new ArrayList<>();
        int n = quality.length;

        for(int i = 0; i<n; i++){
            double ratio = (double) wage[i] / quality[i];
            workers.add(new Worker(ratio, quality[i]));
        }

        // Step 2: Sort workers by ratio
        workers.sort((a,b) -> Double.compare(a.ratio, b.ratio));

        // Step 3 :Initialize
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double sumQuality = 0;
        double ans = Double.MAX_VALUE;

        // Step 4 : Processing for each worker in sorted order
        for(Worker w : workers){
            // add worker
            maxHeap.add(w.quality);
            sumQuality += w.quality;

            // If more than k workers, remove the one with largest quality
            if(maxHeap.size() > k)
                sumQuality -= maxHeap.poll();

            // If exactly k workers, compute cost
            if(maxHeap.size() == k){
                double cost = w.ratio * sumQuality;
                ans = Math.min(cost, ans);
            }
        }

        return ans;
    }
}