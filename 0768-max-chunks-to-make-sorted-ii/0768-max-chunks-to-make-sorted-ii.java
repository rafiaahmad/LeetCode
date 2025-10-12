class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        //Step 1 : Copy and sort the array
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        //Step 2 : Hashmap to count frequency of numbers seen so far
        HashMap<Integer, Integer> freqOriginal = new HashMap<>();
        HashMap<Integer, Integer> freqSorted = new HashMap<>();

        int chunks = 0;

        //Step 3 : Traverse both arrays simultaneously
        for(int i = 0; i<arr.length; i++){

            //Update frequency for original arr[i]
            freqOriginal.put(arr[i], freqOriginal.getOrDefault(arr[i], 0) + 1);
            if(freqOriginal.get(arr[i]) == 0)
                freqOriginal.remove(arr[i]);

            //Update frequency for sorted array
            freqSorted.put(sorted[i], freqSorted.getOrDefault(sorted[i], 0) + 1);
            if(freqSorted.get(sorted[i]) == 0)
                freqSorted.remove(sorted[i]);

            //Step 4 : compare both frequency maps and count chunk
            if(freqOriginal.equals(freqSorted))
                chunks++;
        }
        return chunks;
    }
}