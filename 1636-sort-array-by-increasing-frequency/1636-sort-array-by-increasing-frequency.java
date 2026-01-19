class Solution {
    static class Pair{
        int freq;
        int value;

        Pair(int freq, int value){
            this.freq = freq;
            this.value = value;
        }
    }

    public int[] frequencySort(int[] nums) {
        // Step 1 : Frequency Counting
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        // Step 2 : Build Heap (Low Freq first --> Min Heap)
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> {
            if(a.freq != b.freq)
                return a.freq - b.freq; // Low Frequency First
            return b.value - a.value; // High Value First
        });

        // Iterate over Map entry
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet())
            minHeap.offer(new Pair(entry.getValue(), entry.getKey()));

        // Step 3 : Build the sorted array
        int[] res = new int[nums.length];
        int k = 0;
        while(!minHeap.isEmpty()){
            for(int i = 0; i<minHeap.peek().freq; i++)
                res[k++] = minHeap.peek().value;
            minHeap.poll();
        }

        return res;
    }
}