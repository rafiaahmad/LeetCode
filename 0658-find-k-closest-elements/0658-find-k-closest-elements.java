class Solution {
    static class Pair{
        int value;
        int diff;

        Pair(int value, int diff){
            this.value = value;
            this.diff = diff;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.diff - a.diff);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a.diff != b.diff) {
                    return b.diff - a.diff;     // larger distance first
                }
                return b.value - a.value;       // larger value first
            }
            );

        for(int num : arr){
            int diff = Math.abs(num - x);
            maxHeap.offer(new Pair(num, diff));

            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        // List<Integer> res = new ArrayList<>();
        // while (!maxHeap.isEmpty())
        //     res.add(maxHeap.poll().value);

        // return res;

        // TreeSet keeps ascending order automatically
        // TreeSet<Integer> sortedResult = new TreeSet<>();
        // while (!maxHeap.isEmpty()) {
        //     sortedResult.add(maxHeap.poll().value);
        // }

        // return new ArrayList<>(sortedResult);

        // TreeMap = sorted + allows duplicates
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (!maxHeap.isEmpty()) {
            int val = maxHeap.poll().value;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();
            while (count-- > 0) {
                res.add(val);
            }
        }

        return res;
    }
}