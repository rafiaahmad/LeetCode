class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        Map<Integer, Integer> count = new HashMap<>();
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
            if (count.get(arr[i]) == 0) count.remove(arr[i]);

            count.put(sorted[i], count.getOrDefault(sorted[i], 0) - 1);
            if (count.get(sorted[i]) == 0) count.remove(sorted[i]);

            if (count.isEmpty())
                chunks++;
        }
        return chunks;
    }
}