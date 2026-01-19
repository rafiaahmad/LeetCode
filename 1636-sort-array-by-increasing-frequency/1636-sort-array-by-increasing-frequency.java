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

        // Step 2 : Build Heap (High Freq first --> Max Heap)
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> {
            if(a.freq != b.freq)
                return a.freq - b.freq; // frequency low
            return b.value - a.value; // value high
        });

        // Iterate over Map entry
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet())
            maxHeap.offer(new Pair(entry.getValue(), entry.getKey()));

        // Step 3 : Build the sorted array
        int[] res = new int[nums.length];
        int k = 0;
        while(!maxHeap.isEmpty()){
            for(int i = 0; i<maxHeap.peek().freq; i++)
                res[k++] = maxHeap.peek().value;
            maxHeap.poll();
        }

        return res;
    }
}