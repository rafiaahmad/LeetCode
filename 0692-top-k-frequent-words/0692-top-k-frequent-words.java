class Solution {
    static class Pair{
            int freq;
            String word;

            Pair(int freq, String word){
            this.freq = freq;
            this.word = word;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Frequency Counting
        HashMap<String, Integer> freq = new HashMap<>();
        for(String word : words)
            freq.put(word, freq.getOrDefault(word, 0) + 1);

        // Step 2 : Build Heap
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> {
            if(a.freq != b.freq)
                return a.freq - b.freq;         // lower freq is worse
            return b.word.compareTo(a.word);    // lexicographically larger is worse
        });

        // Iterate over map entry
        for(Map.Entry<String, Integer> entry : freq.entrySet()){
            minHeap.offer(new Pair(entry.getValue(), entry.getKey()));

            if(minHeap.size() > k)
                minHeap.poll();
        }

        // Step 3 : Build Result of tok K Frequent words
        List<String> res = new ArrayList<>();
        while(!minHeap.isEmpty())
            res.addFirst(minHeap.poll().word);

        return res;
    }
}