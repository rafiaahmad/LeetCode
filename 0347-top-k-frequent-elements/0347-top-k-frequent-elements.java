class Solution {
    static class Pair{
        int freq;
        int value;

        Pair(int freq, int value){
            this.freq = freq;
            this.value = value;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1 : Frequency counting
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        // Step 2 : Build Heap
        // PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
                    (a, b) -> {
                        if (a.freq != b.freq) {
                            return a.freq - b.freq;     // lower freq first
                        }
                        return b.value - a.value;       // larger value first
                    }
                );

        //Iterate over map entry
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            minHeap.offer(new Pair(entry.getValue(), entry.getKey()));

            if(minHeap.size() > k)
                minHeap.poll();
        }

        // Step 3 : Build Top K Frequent element result
        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll().value;
        }

        return res;
    }
}