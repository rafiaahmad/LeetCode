class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Frequency Counting
        HashMap<String, Integer> freq = new HashMap<>();
        for(String word : words)
            freq.put(word, freq.getOrDefault(word, 0) + 1);

        // Step 2 : Buckets (Index = Frequency)
        List<String>[] buckets = new List[words.length + 1];
        for(int i = 0; i <= words.length; i++)
            buckets[i] = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : freq.entrySet()){
            String word = entry.getKey();
            int freqWord = entry.getValue();
            buckets[freqWord].add(word);
        }

         // 🔥 FIX: sort each bucket lexicographically
        for (int i = 0; i <= words.length; i++) {
            Collections.sort(buckets[i]);
        }

        // Step 3 : Collect Top K
        List<String> res = new LinkedList<>();
        int idx = 0;
        for(int frequency = words.length; frequency >= 0 && idx < k; frequency--){
            for(String word : buckets[frequency]){
                idx++;
                res.add(word);
                if(idx == k) break;
            }
        }

        return res;
    }
}