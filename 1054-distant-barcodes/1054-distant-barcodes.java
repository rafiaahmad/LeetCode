class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        // 1) Count frequencies
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int b : barcodes) {
            freq.put(b, freq.getOrDefault(b, 0) + 1);
        }

        // 2) Max heap by frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int key : freq.keySet()) {
            pq.add(new int[]{key, freq.get(key)});
        }

        int n = barcodes.length;
        int[] result = new int[n];
        int index = 0;

        // 3) Greedy place
        while (pq.size() > 1) {
            int[] first = pq.poll();
            int[] second = pq.poll();

            result[index++] = first[0];
            result[index++] = second[0];

            if (--first[1] > 0) pq.add(first);
            if (--second[1] > 0) pq.add(second);
        }

        // 4) If one remains
        if (!pq.isEmpty()) {
            result[index] = pq.poll()[0];
        }

        return result;
    }
}
